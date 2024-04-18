import React, { useEffect, useMemo, useState } from 'react'
import { useModel } from '@umijs/max';
import { CardT } from '@/components'
import { Table, Tag } from 'antd';
import { AbsentRecordServlet } from '@/services/user/api'

export default function List() {
    const { initialState } = useModel('@@initialState');
    const teacherID = initialState?.currentUser.data?.teacherNum
  const [data,setData] = useState<any>([])

  useEffect(() => {
    AbsentRecordServlet({teacherID}).then(res => {
      if(res.code === 0){
        setData(res.data)
      }
    })
  },[])
  
  console.log(data,'4567890-')
  
  const columns = [
      {
        title: '编号',
        dataIndex: 'number',
        key: 'number',
        width: 50,
        fixed: 'left',
      },
      {
        title: '姓名',
        dataIndex: 'name',
        key: 'name',
        width: 50,
        fixed: 'left',
      },
      {
        title: '班级',
        dataIndex: 'stuClass',
        width: 80,
        key: 'stuClass',
      },
      {
        title: '学号',
        dataIndex: 'stuNum',
        width: 80,
        key: 'stuNum',
      },
      {
        title: '课程',
        dataIndex: 'course',
        width: 80,
        key: 'course',
      },
      {
        title: '旷课时间',
        dataIndex: 'courseTime',
        key: 'courseTime',
        width: 90,
        fixed: 'right',
      },
    ];
  return (
    <CardT title={`${data.time}旷课记录`}>
      <Table columns={columns} dataSource={data.absentRecords} scroll={{ x: 1500 }} rowKey="leaveRecordNum" />
    </CardT>
  )
}

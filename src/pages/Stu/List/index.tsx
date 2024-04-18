import React, { useEffect, useMemo, useState } from 'react'
import { useModel } from '@umijs/max';
import { CardT } from '@/components'
import { Table, Tag } from 'antd';
import { CheckResultServlet } from '@/services/user/api'

export default function List() {
  const { initialState } = useModel('@@initialState');
  const studentID = initialState?.currentUser.data?.studentNumber
  const [data,setData] = useState([])

  useEffect(() => {
    CheckResultServlet({studentID}).then(res => {
      if(res.code === 0){
        setData(res.data.resArrayList)
      }
    })
  },[])
  
  console.log(data,'4567890-')
  
  const columns = useMemo(() => {
    const status = new Map([
      ['pass', '通过'],
      ['fail', '未通过'],
      ['waiting', '等待']
    ])
    const colors = new Map([
      ['pass', 'green'],
      ['fail', 'red'],
      ['waiting', 'yellow']
    ])

    return [
      {
        title: '编号',
        dataIndex: 'leaveRecordNum',
        key: 'id',
        width: 50,
        fixed: 'left',
      },
      {
        title: '请假时间',
        dataIndex: 'time',
        key: 'time',
        width: 50,
        fixed: 'left',
      },
      {
        title: '审批教师',
        dataIndex: 'teacher',
        width: 80,
        key: 'teacher',
      },
      {
        title: '请假原因',
        dataIndex: 'reason',
        width: 150,
        key: 'reason',
      },
      {
        title: '是否通过',
        dataIndex: 'result',
        key: 'result',
        width: 50,
        fixed: 'right',
        render: (evn: string) => (
          <Tag color={colors.get(evn)}>{status.get(evn)}</Tag>
        ),
      },
    ];
  }, []);
  return (
    <CardT title='申请列表'>
      <Table columns={columns} dataSource={data} scroll={{ x: 1500 }} rowKey="leaveRecordNum" />
    </CardT>
  )
}

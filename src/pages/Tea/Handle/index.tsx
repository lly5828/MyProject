import React, { useEffect, useState } from 'react';
import { Button, Spin, Table, message } from 'antd';
import type { TableColumnsType } from 'antd';
import { CardT } from '@/components'
import { CheckOutlined, CloseOutlined } from '@ant-design/icons';
import { DealLeave, GetDealLeave } from '@/services/user/api'
import { useModel } from '@umijs/max';

interface DataType {
  key: React.Key;
  name: string;
  age: number;
  address: string;
}

export default function Handle() {
  const { initialState, setInitialState } = useModel('@@initialState');
  const teacherID = initialState?.currentUser.data?.teacherNum
  const [data, setData] = useState<API.DeaData[]>()
  const [spinning,setSpinning] = useState(true)

  const Deal = () => {
    DealLeave({teacherID}).then((res:API.DealLeave) => {
      if(res.code === 0){
        setData(res?.data)
        setSpinning(false)
      }
    })
  }
  const agree = (v:any, bol:boolean) => {
    setSpinning(true)
    GetDealLeave({teacherID,leaveRecordNum:v, result:bol}).then((res:API.AskForLeave) => {
      if(res.code === 0){
        Deal()
        message.open({
          type: 'success',
          content: '审批成功！',
        });
        return
      }
      message.open({
        type: 'error',
        content: '审批失败！',
      });
    })
  }

  const columns: TableColumnsType<DataType> = [
    {
      title: '编号',
      width: 50,
      dataIndex: 'leaveRecordNum',
      key: 'leaveRecordNum',
      fixed: 'left',
    },
    {
      title: '姓名',
      width: 80,
      dataIndex: 'student',
      key: 'student',
      fixed: 'left',
    },
    {
      title: '班级',
      width: 100,
      dataIndex: 'myClass',
      key: 'myClass',
    },
    {
      title: '请假时间',
      dataIndex: 'time',
      key: 'time',
      width: 150,
    },
    {
      title: '原因',
      dataIndex: 'reason',
      key: 'reason',
      width: 150,
    },
    {
      title: '操作',
      key: 'operation',
      fixed: 'right',
      width: 120,
      render: ({leaveRecordNum}) => {
        return (
          <>
            <Button icon={<CheckOutlined />} style={{ width: '80px', marginRight: '20px' }} type="primary" onClick={() => {agree(leaveRecordNum,true)}}></Button>
            <Button icon={<CloseOutlined />} style={{ width: '80px' }} danger type="primary"  onClick={() => {agree(leaveRecordNum,false)}}></Button>
          </>
        )
      },
    },
  ];

  useEffect(() => {
    Deal()
  },[])

  return (
    <CardT title='请假审批'>
      {
        spinning ? <Spin tip="Loading" size="large">
          <div className="content" />
        </Spin> : <Table columns={columns} dataSource={data} scroll={{ x: 1500 }} bordered />
      }
    </CardT>
  )
}

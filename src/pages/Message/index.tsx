import React, { useState } from 'react';
import { Descriptions, Badge, Button } from 'antd';
import type { DescriptionsProps } from 'antd';
import { CardT } from '@/components'
import { useModel } from '@umijs/max';

const App: React.FC = () => {
  const a = true
  const { initialState }: any = useModel('@@initialState');
  const [messages, setMessage] = useState(initialState.currentUser.data)
  console.log(messages)
  const items: DescriptionsProps['items'] = [
    {
      key: '1',
      label: '姓名',
      children: messages.name,
      // span: 2,
    },
    // {
    //   key: '2',
    //   label: '年龄',
    //   children: '14',
    // },
    {
      key: '3',
      label: '性别',
      children: messages.sex ? '男' : '女',
      // span: 1,
    },
    {
      key: '4',
      label: '班级',
      children: messages.myClass ?? messages.teachClass,
      // span: 3,
    },
    {
      key: '5',
      label: '电话',
      children: messages.phoneNum,
      span: 3,
    },
    {
      key: '6',
      label: '学号/职工号',
      children: messages.studentNumber ?? messages.teacherNum,
      span: 3,
    },
    {
      key: '7',
      label: '状态',
      children: <Badge status="processing" text="正常" />,
      span: 3,
    },
    ////暂时用不上，该功能完善后开放即可
    // {
    //   key: '8',
    //   label: '信息有误？',
    //   children: <Button >修改信息</Button>,
    //   span: 3,
    // },
  ];
  return (
    <CardT title='个人信息'>
      <Descriptions bordered items={items} />
    </CardT>
  )
}

export default App;
import React from 'react'
import { Table, Tag } from 'antd';

export default function MyTable() {
  const tagColorMap = new Map([
    ['高数', 'red'],
    ['英语', 'yellow'],
    ['Java', 'green'],
    ['Python', 'blue'],
    ['PHP', 'orange']
    // 添加更多课程和颜色
  ]);
  const renderCell = (v: string) => {
    console.log(tagColorMap.get(v))
    return (<Tag color={tagColorMap.get(v)}>{v}</Tag>)
  };

  const columns = [
    {
      title: '节次/星期',
      dataIndex: 'sections',
    },
    {
      title: '周一',
      dataIndex: 'Monday',
      render: renderCell,
    },
    {
      title: '周二',
      dataIndex: 'Tuesday',
      render: renderCell,
    },
    {
      title: '周三',
      dataIndex: 'Wednesday',
      render: renderCell,
    },
    {
      title: '周四',
      dataIndex: 'Thursday',
      render: renderCell,
    },
    {
      title: '周五',
      dataIndex: 'Friday',
      render: renderCell,
    },
  ];
  const data = [
    {
      key: '1',
      sections: '第1节',
      Monday: '英语'
    },
    {
      key: '2',
      sections: '第2节',
      Monday: 'Java',
      Thursday:'高数',
      Tuesday:'PHP'
    },
    {
      key: '3',
      sections: '第3节',
      Tuesday:'PHP'
    },
  ];
  return (
    <Table columns={columns} dataSource={data} pagination={false} bordered={true} />
  )
}
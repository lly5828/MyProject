import { useModel } from '@umijs/max';
import { CardT } from '@/components'
import React, { useEffect, useState } from 'react';
import { GetCourseT, GetCourseS } from '@/services/user/api'
import { Table, Tag } from 'antd';

/**
 * 每个单独的卡片，为了复用样式抽成了组件
 * @param param0
 * @returns
 */
const Welcome: React.FC = () => {
  const { initialState } = useModel('@@initialState');
  const studentID = initialState?.currentUser.data?.studentNumber
  const teacherID = initialState?.currentUser.data?.teacherNum
  const [Course, setCourse] = useState<string[][]>()
  const [result,setresult] = useState<any>()

  useEffect(() => {
    if (studentID) {
      GetCourseS({ studentID }).then(res => {
        setCourse(res.data)
      })
      return
    }
    GetCourseT({teacherID}).then(res => {
      setCourse(res.data)
    })
  }, [])
  console.log(Course)

  const tagColorMap = new Map([
    ['语文', 'red'],
    ['数学', 'yellow'],
    ['英语', 'green'],
    ['物理', 'blue'],
    ['化学', 'orange'],
    ['生物', 'purple'],
    ['Java', 'cyan'],
    ['Python', 'pink'],
    ['政治', 'magenta'],
    ['历史', 'volcano'],
    ['地理', 'gold'],
  ]);
  const renderCell = (v: string) => {
    // console.log(tagColorMap.get(v))
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

  const transformData = (data: string[][]) => {
    const transformed: any[] = [];
    const daysOfWeek = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday'];
  
    for (let i = 0; i < 8; i++) {
      const entry: any = {
        key: `${i + 1}`,
        sections: `第${i + 1}节`,
      };
  
      daysOfWeek.forEach((day, index) => {
        if (data[index] && data[index][i]) {
          entry[day] = data[index][i];
        }
      });
  
      transformed.push(entry);
    }
  
    return transformed;
  };
  

  useEffect(() => {
    if (Course) {
      const transformedData = transformData(Course as string[][]);
      setresult(transformedData);
    }
  }, [Course]);
  return (
    <CardT title='课程表'>
      <Table columns={columns} dataSource={result} pagination={false} bordered={true} />
    </CardT>
  );
};

export default Welcome;
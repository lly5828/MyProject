import { CardT } from '@/components'
import React, { useEffect, useState } from 'react';
import type { Dayjs } from 'dayjs';
import { Calendar, Col, Row, Tag } from 'antd';
import type { CalendarProps } from 'antd';
import dayjs from 'dayjs';
import { Attendance } from '@/services/user/api'
import { useModel } from '@umijs/max';

const App: React.FC = () => {
  const { initialState, setInitialState } = useModel('@@initialState');
  const onPanelChange = (value: Dayjs, mode: CalendarProps<Dayjs>['mode']) => {
    console.log(value.format('YYYY-MM-DD'), mode);
  };

  const [attendanceDate, setattendanceDate] = useState<API.AttData[]>([])

  useEffect(() => {
    Attendance({ studentID: initialState?.currentUser.data?.studentNumber }).then((res: any) => {
      setattendanceDate(res.data)
    })
  }, [])

  // 将 attendanceDate 转换为对象映射
  console.log(attendanceDate)
  const attendanceMap = new Map(

    attendanceDate?.map(entry => [entry.day, entry])
  );

  const getListData = (value: dayjs.Dayjs) => {
    const targetDate = value.format('YYYY-MM-DD');
    const targetEntry = attendanceMap.get(targetDate);
    // if (!targetEntry) {
    //   return [{ color: 'green', content: '正常' }];
    // }

    return targetEntry ? [targetEntry] : [];
  };
  const dateCellRender = (value: Dayjs) => {
    const listData = getListData(value);
    return (
      <ul className="events">
        {listData.map(item => (
          <Row key={item.day}>
            <Col span={24}>
              <Tag color={item.ifAskForLeave ? 'green' : 'red'} >{item.ifAskForLeave ? '请假' : '未请假'}</Tag>
            </Col>
            <Col span={24}>
              <Tag color='blue' >正常出勤：{item.normal}</Tag>
            </Col>
            <Col span={24}>
              <Tag color='yellow' >旷课：{item.leave}</Tag>
            </Col>
          </Row>
        ))}
      </ul>
    );
  };
  const cellRender: CalendarProps<Dayjs>['cellRender'] = (current, info) => {
    return dateCellRender(current);
  };

  return (
    <CardT title="出勤查询">
      <div style={{ border: '1px rgba(46, 50, 56, 0.13) solid', borderRadius: '5px', padding: '20px' }}>
        <Calendar
          onPanelChange={onPanelChange}
          mode='month'
          cellRender={cellRender}
        />
      </div>
    </CardT>
  );
};

export default App;
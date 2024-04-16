import { useModel } from '@umijs/max';
// import { theme } from 'antd';
import { MyTable, CardT } from '@/components'
import React, { useEffect } from 'react';
import { GetCourseT, GetCourseS } from '@/services/user/api'

/**
 * 每个单独的卡片，为了复用样式抽成了组件
 * @param param0
 * @returns
 */
const Welcome: React.FC = () => {
  // const { token } = theme.useToken();
  const { initialState } = useModel('@@initialState');
  console.log(initialState,'aaa')
  const studentNumber = initialState?.currentUser.data?.studentNumber
  // const teacherNum = initialState?.currentUser.data?.studentNumber

  useEffect(() => {
    if (studentNumber) {
      // GetCourseS(initialState?.currentUser.data.studentNumber).then(res => {
      //   console.log(res)
      // })
      return
    }
    console.log('reaadwawdaws')
  }, [])
  return (
    <CardT title='课程表'>
      <MyTable></MyTable>
    </CardT>
  );
};

export default Welcome;
// import { useModel } from '@umijs/max';
// import { theme } from 'antd';
import {MyTable, CardT } from '@/components'
import React from 'react';

/**
 * 每个单独的卡片，为了复用样式抽成了组件
 * @param param0
 * @returns
 */
const Welcome: React.FC = () => {
  // const { token } = theme.useToken();
  // const { initialState } = useModel('@@initialState');
  return (
      <CardT title='课程表'>
        <MyTable></MyTable>
      </CardT>
  );
};

export default Welcome;
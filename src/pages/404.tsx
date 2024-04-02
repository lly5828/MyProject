import { history, useIntl } from '@umijs/max';
import { Button, Result } from 'antd';
import React from 'react';

const NoFoundPage: React.FC = () => (
  <Result
    status="403"
    title="403"
    // subTitle={useIntl().formatMessage({ id: 'pages.404.subTitle' })}
    subTitle="抱歉！您没有权限访问该页面"
    extra={
      <Button type="primary" onClick={() => history.push('/')}>
        {useIntl().formatMessage({ id: 'pages.404.buttonText' })}
      </Button>
    }
  />
);

export default NoFoundPage;

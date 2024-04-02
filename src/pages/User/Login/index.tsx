import { stuLogin,teaLogin } from '@/services/user/login';
import { useIntl, useModel } from '@umijs/max';
import { message } from 'antd';
import React from 'react';
import { LockOutlined, UserOutlined } from '@ant-design/icons';
import { Button, Form, Input, Select } from 'antd';
import Style from './index.module.css'
import loginC from '@/assets/image/loginC.png'
import { flushSync } from 'react-dom';
import { history } from '@umijs/max';
import logo from '@/assets/image/logo.png'

const Login: React.FC = () => {
  // const [userLoginState, setUserLoginState] = useState<API.LoginResult>({});
  // const [type, setType] = useState<string>('account');
  const { initialState, setInitialState } = useModel('@@initialState');
  // const { styles } = useStyles();
  const intl = useIntl();

  const fetchUserInfo = async () => {
    const userInfo = await initialState?.fetchUserInfo?.();
    if (userInfo) {
      flushSync(() => {
        setInitialState((s) => ({
          ...s,
          currentUser: userInfo,
        }));
      });
    }
  };

  const onFinish = async (values:{role:string,username:string,password:string}) => {
    try {
      let msg:any;
      if(values.role === 'xs'){
        msg = stuLogin(values.username as string,values.password as string)
      }else{
        msg = teaLogin(values.username as string,values.password as string)
      }
      // 登录
      msg.then((res: any) => {
        console.log(res)
        if (res.code === 0) {
          // window.localStorage.setItem('token', JSON.stringify(msg.data.token));
          window.localStorage.setItem('user', JSON.stringify(res));
          message.success('登录成功！');
          fetchUserInfo();
          const urlParams = new URL(window.location.href).searchParams;
          history.push(urlParams.get('redirect') || '/');
          return;
        }
        // 如果失败去设置用户错误信息
        message.error('用户名密码错误！');
      })
    } catch (error) {
      const defaultLoginFailureMessage = intl.formatMessage({
        id: 'pages.login.failure',
        defaultMessage: '登录失败，请重试！',
      });
      console.log(error);
      message.error(defaultLoginFailureMessage);
    }
  };

  return (
    <div className={Style.container}>
      <div className={Style.BackeBox}>
        <img src={loginC} style={{ width: '350px' }}></img>
      </div>
      <div className={Style.FromBox}>
        <div className={Style.loginFrom}>
          <div className={Style.Title}>
            <img src={logo} style={{width:'50px',height:'50px'}}></img>
            <span style={{margin:'10px 30px'}}>智慧考勤</span>
            </div>
          <Form
            name="normal_login"
            className="login-form"
            initialValues={{ remember: true }}
            onFinish={onFinish}
          >
            <Form.Item name='role'>
              <Select
                // onChange={handleChange}
                placeholder="请选择身份"
                options={[
                  { value: 'xs', label: '学生' },
                  { value: 'js', label: '教师' },
                ]}
              />
            </Form.Item>

            <Form.Item
              name="username"
              rules={[{ required: true, message: 'Please input your Username!' }]}
            >
              <Input
                prefix={<UserOutlined className="site-form-item-icon" />}
                placeholder='姓名'
              />
            </Form.Item>
            <Form.Item
              name="password"
              rules={[{ required: true, message: 'Please input your Password!' }]}
            >
              <Input
                prefix={<LockOutlined className="site-form-item-icon" />}
                type="password"
                placeholder='ID'
              />
            </Form.Item>
            <Form.Item>
              <Button type="primary" htmlType="submit" className="login-form-button">
                登录
              </Button>
            </Form.Item>
          </Form>
        </div>
      </div>
    </div>
  );
};

export default Login;
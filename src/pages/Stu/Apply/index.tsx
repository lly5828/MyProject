import { CardT } from '@/components'
import { Button, Form, type FormProps, Input, DatePicker, Row, Col, message } from 'antd';
import { useModel } from '@umijs/max';
import { AskForLeave } from '@/services/user/api'

type FieldType = {
  username?: string;
  password?: string;
  remember?: string;
};

export default function Apply() {
  const stuID = useModel('@@initialState')?.initialState?.currentUser.data.studentNumber
  const [form] = Form.useForm();
  const initialValues = {
    studentID: stuID, // 初始值为空字符串或其他初始值
  };

  const onFinish: FormProps<FieldType>["onFinish"] = (values: any) => {
    values.time = values.time.format('YYYY-MM-DD')
    AskForLeave(values).then(res => {
      if (res.code === 0) {
        message.open({
          type: 'success',
          content: '提交成功！等待审批中',
        });
        form.resetFields();
      }
    })
  };

  return (
    <CardT title='请假申请'>
      <div style={{ border: '1px rgba(46, 50, 56, 0.13) solid', borderRadius: '5px', padding: '20px' }}>
        <Form
        form={form}
        initialValues={initialValues}
          onFinish={onFinish}
        >
          <Row gutter={16}>
            <Col span={12}>
              <Form.Item label="请假人ID" name="studentID">
                <Input style={{ width: 200 }} disabled defaultValue={stuID} />
              </Form.Item>
            </Col>
            <Col span={12}>
              <Form.Item label="请假时间" name="time" rules={[{ required: true, message: '请选择请假时间!' }]}>
                <DatePicker style={{ width: '200px' }} />
              </Form.Item>
            </Col>
          </Row>
          <Row>
            <Col span={24}>
              <Form.Item label="请假原因" name="reason" rules={[{ required: true, message: '请输入请假原因!' }]}>
                <Input />
              </Form.Item>
            </Col>
          </Row>
          <Row>
            <Col span={24}>
              <Form.Item>
                <Button type="primary" htmlType="submit">
                  提交
                </Button>
              </Form.Item>
            </Col>
          </Row>
        </Form>
      </div>
    </CardT>
  )
}

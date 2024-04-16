import React from 'react'
import { CardT } from '@/components'
import { Button, Form, type FormProps, Input, DatePicker, Row, Col, Select } from 'antd';

type FieldType = {
  username?: string;
  password?: string;
  remember?: string;
};

const onFinish: FormProps<FieldType>["onFinish"] = (values:any) => {
  values.Time = values.Time.format('YYYY-MM-DD')
};
export default function Adjust() {
  return (
    <CardT title='调整课程'>
      <div style={{ border: '1px rgba(46, 50, 56, 0.13) solid', borderRadius: '5px', padding: '20px' }}>
        <Form
          onFinish={onFinish}
        >
          <Row gutter={16}>
            <Col span={12}>
              <Form.Item label="需调整的课程时间" name="QTime">
                <DatePicker style={{ width: '200px' }} />
              </Form.Item>
            </Col>
            <Col span={12}>
            <Form.Item label="调整后的课程时间" name="QTime">
                <DatePicker style={{ width: '200px' }} />
              </Form.Item>
            </Col>
          </Row>
          <Row>
            <Col span={24}>
              <Form.Item label="请假原因" name="Reason">
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

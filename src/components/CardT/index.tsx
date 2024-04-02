import { Card } from 'antd'
import React from 'react'
import Style from './index.module.css'
import { useModel } from '@umijs/max';

const CardT = ({ children,mar,title }:any) => {
    const { initialState } = useModel('@@initialState');
    return (
        <Card
            style={{
                borderRadius: 8,
                marginTop: mar,
                minWidth:'900px',
                minHeight:"200px"
            }}
            bodyStyle={{
                backgroundImage:
                    initialState?.settings?.navTheme === 'realDark'
                        ? 'background-image: linear-gradient(75deg, #1A1B1F 0%, #191C1F 100%)'
                        : 'background-image: linear-gradient(75deg, #FBFDFF 0%, #F5F7FF 100%)',
            }}
        >
            <div className={Style.top_cont}>
                <div className={Style.tag}></div>
                <h4 className={Style.h4_font}>{title}</h4>
            </div>
            {children}
        </Card>
    )
}

export default CardT
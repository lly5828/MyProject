// @ts-ignore
/* eslint-disable */

declare namespace API {
    type Login = {
        code: number;
        message: string;
        data: {
            name: string;
            sex: boolean;
            phoneNum: string;
            myClass: string;
            studentNumber: string;
            status: string;
        };
    };
    type Attendance = {
        code: number;
        message: string;
        data: AttData[]
    };
    export interface AttData {
        day: string;
        ifAskForLeave: boolean;
        normal: number;
        leave: number;
    }
    type AskForLeave = {
        code: number;
        message: string;
    }
    export interface DeaData {
        leaveRecordNum: number;
        student: string;
        studentID: string;
        myClass: string;
        time: string;
        reason: string;
    }
    
    type DealLeave = {
        code: number;
        message: string;
        data: DeaData[];
    }
    // interface Data {
    //     role: string,
    //     username: string,
    //     token: string
    // }

    // interface RootObject {
    //     status: string;
    //     data: Data
    // }

    // type CurrentUser = {
    //     role?: string;
    //     username?: string;
    //     avatar?: string;
    //     userid?: string;
    //     email?: string;
    //     signature?: string;
    //     title?: string;
    //     group?: string;
    //     tags?: { key?: string; label?: string }[];
    //     notifyCount?: number;
    //     unreadCount?: number;
    //     country?: string;
    //     access?: string;
    //     geographic?: {
    //         province?: { label?: string; key?: string };
    //         city?: { label?: string; key?: string };
    //     };
    //     address?: string;
    //     phone?: string;
    //     teacherNumber?: string;
    //     name?: string;
    // };
}
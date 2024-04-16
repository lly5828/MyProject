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

    type Course = {
        code: number;
        message: string;
        data: string[][];
    }
}
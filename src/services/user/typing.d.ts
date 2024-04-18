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

    export interface ResArrayList {
        leaveRecordNum: number;
        teacher: string;
        time: string;
        reason: string;
        result: string;
    }
    
    export interface CheckResultData {
        resArrayList: ResArrayList[];
    }
    
    type CheckResult = {
        code: number;
        message: string;
        data: CheckResultData;
    }

    export interface AbsentRecord {
        number: number;
        name: string;
        stuClass: string;
        stuNum: number;
        course: string;
        courseTime: string;
    }
    
    export interface AbsentRecordData {
        time: string;
        absentRecords: AbsentRecord[];
    }
    
    export interface AbsentRecord {
        code: number;
        message: string;
        data: AbsentRecordData;
    }
}
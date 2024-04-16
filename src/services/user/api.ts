import { request } from '@umijs/max';

// export async function stuLogin(name: string, studentID: string) {
//     const params = new URLSearchParams({
//       name,
//       studentID
//     });
  
//     const url = `/test/StudentMainServlet`;
  
//     const response = await request<API.RootObject>(url, {
//       method: 'GET',
//       headers: {
//         'Content-Type': 'application/json',
//       },
//     });
  
//     return response;
//   }

//获取学生缺勤记录 /test/AttendanceRecordServlet post
// export async function Attendance(body: { [key: string]: any }) {
//   return request<API.Attendance>('/test/AttendanceRecordServlet', {
//     method: 'POST',
//     headers: {
//       'Content-Type': 'application/json',
//     },
//     data: body,
//   });
// }
export async function Attendance(body: { [key: string]: any }) {
  const params = new URLSearchParams(body);

  const url = `/test/AttendanceRecordServlet?${params}`;

  const response = await request<API.Attendance>(url, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    timeout: 100000, // 设置超时时间为 100 秒
  });

  return response;
}

// // 学生提交请假申请接口 /test/AskForLeaveServlet post
// export async function AskForLeave(body: { [key: string]: string }) {
//   return request<API.AskForLeave>('/test/AskForLeaveServlet', {
//     method: 'POST',
//     headers: {
//       'Content-Type': 'application/json',
//     },
//     data: body,
//   });
// }

// 学生提交请假申请接口 /test/AskForLeaveServlet post 通过url传参数，后期改
export async function AskForLeave(body: { [key: string]: any }) {
    const params = new URLSearchParams(body);
  
    const url = `/test/AskForLeaveServlet?${params}`;
  
    const response = await request<API.AskForLeave>(url, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
    });
  
    return response;
  }

//教师获取学生请假申请接口 /test/DealLeaveServlet
// export async function DealLeave(body: { [key: string]: any }) {
//   return request<API.DealLeave>('/test/DealLeaveServlet', {
//     method: 'POST',
//     headers: {
//       'Content-Type': 'application/json',
//     },
//     data: body,
//   });
// }

export async function DealLeave(body: { [key: string]: any }) {
  const params = new URLSearchParams(body);

  const url = `/test/DealLeaveServlet?${params}`;

  const response = await request<API.DealLeave>(url, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
  });

  return response;
}

//教师审批学生请假申请接口 /test/DealLeaveServlet post
// export async function GetDealLeave(body: { [key: string]: any }) {
//   return request<API.AskForLeave>('/test/DealLeaveServlet', {
//     method: 'GET',
//     headers: {
//       'Content-Type': 'application/json',
//     },
//     data: body,
//   });
// }

export async function GetDealLeave(body: { [key: string]: any }) {
  const params = new URLSearchParams(body);

  const url = `/test/DealLeaveServlet?${params}`;

  const response = await request<API.AskForLeave>(url, {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json',
    },
  });

  return response;
}

//获取课程表信息 
//学生：http://localhost:8080/test/CourseTableServlet
//教师：http://localhost:8080/test/CourseTableServlet
export async function GetCourseS(body: { [key: string]: any }) {
  const params = new URLSearchParams(body);

  const url = `/test/CourseTableServlet?${params}`;

  const response = await request<API.Course>(url, {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json',
    },
  });

  return response;
}
export async function GetCourseT(body: { [key: string]: any }) {
  const params = new URLSearchParams(body);

  const url = `/test/CourseTableServlet?${params}`;

  const response = await request<API.Course>(url, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
  });

  return response;
}
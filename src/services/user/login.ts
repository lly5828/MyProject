import { request } from '@umijs/max';

/** 登录接口 POST /api/login/account */
// export async function login(body: API.Login) {
//   return request<API.RootObject>('/api/login', {
//     method: 'POST',
//     headers: {
//       'Content-Type': 'application/json',
//     },
//     data: body,
//   });
// }


// 学生登录接口
export async function stuLogin(name: string, studentID: string) {
  const params = new URLSearchParams({
    name,
    studentID
  });

  const url = `/test/LoginStuServlet?${params}`;

  const response = await request<API.Login>(url, {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json',
    },
  });

  return response;
}

//教师登录接口
export async function teaLogin(name: string, teacherID: string) {
  const params = new URLSearchParams({
    name,
    teacherID
  });

  const url = `/test/LoginTeaServlet?${params}`;

  const response = await request<API.Login>(url, {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json',
    },
  });

  return response;
}
export default [
  {
    path: '/user',
    layout: false,
    routes: [{ name: '登录', path: '/user/login', component: './User/Login' }],
  },
  {
    path: '/home',
    name: '数据概况',
    icon: 'smile',
    component: './Home'
  },
  { path: '/message', name: '个人信息', icon: 'user', component: './Message' },
  { path: '/course', name: '课程表', icon: 'table', component: './Course' },
  {
    path: '/stu',
    name: '学生端',
    icon: 'trophy',
    access: 'canStu',
    routes: [
      { path: '/stu', redirect: '/stu/inquire' },
      { path: '/stu/inquire', name: '出勤查询', component: './Stu/Inquire', },
      { path: '/stu/apply', name: '请假申请', component: './Stu/Apply' },
      { path: '/stu/applylist', name: '申请列表', component: './Stu/List' },
    ],
  },
  {
    path: '/tea',
    name: '教师端',
    icon: 'crown',
    routes: [
      { path: '/tea', redirect: '/tea/Adjust' },
      //暂时用不上课程调整先注释路由
      // { path: '/tea/Adjust', name: '课程调整', component: './Tea/Adjust', },
      { path: '/tea/Handle', name: '请假审批', component: './Tea/Handle',access: 'canTea', },
      { path: '/tea/status', name: '旷课记录', component: './Tea/status',access: 'canTea', },
    ],
  },
  { path: '/', redirect: '/home' },
  { path: '*', layout: false, component: './404' },
];


// export default [
//   {
//     path: '/user',
//     layout: false,
//     routes: [{ name: '登录', path: '/user/login', component: './User/Login' }],
//   },
//   {
//     path: '/',
//     component: '../layout/index',
//     menu: {
//       flatMenu: true,
//     },
//     routes: [
//       { path: '/class', name: '课程表', icon: 'smile', component: './Welcome' },
//       { path: '/message', name: '个人信息', icon: 'smile', component: './Message' },
//       {
//         path: '/admin',
//         name: '管理页',
//         icon: 'crown',
//         access: 'canAdmin',
//         routes: [
//           { path: '/admin', redirect: '/admin/sub-page' },
//           { path: '/admin/sub-page', name: '二级管理页', component: './Admin' },
//         ],
//       },
//       { name: '查询表格', icon: 'table', path: '/list', component: './TableList' },
//       { path: '/', redirect: '/class' },
//     ],
//   },
//   { path: '*', layout: false, component: './404' },
// ];
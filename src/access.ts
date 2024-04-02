/**
 * @see https://umijs.org/docs/max/access#access
 * */
export default function access(initialState: { currentUser?: API.CurrentUser } | undefined) {
  const { currentUser }:any = initialState ?? {};
  console.log(currentUser)
  return {
    canTea: currentUser && currentUser.data.teacherNum,
    canStu: currentUser && currentUser.data.studentNumber,
  };
}

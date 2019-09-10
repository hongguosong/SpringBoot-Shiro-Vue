const getters = {
  sidebar: state => state.app.sidebar,
  visitedViews: state => state.app.visitedViews,

  username: state => state.user.username,
  nickname: state => state.user.nickname,
  userId: state => state.user.userId,
  avatar: state => state.user.avatar,
  role: state => state.user.role,
  menus: state => state.user.menus,
  permissions: state => state.user.permissions,

  permission_routers: state => state.permission.routers,
  addRouters: state => state.permission.addRouters,

  alarmDialogVisible: state => state.alarmDialogVisible,
  alarmData: state => state.alarmData,
  alarmCount: state => state.alarmData.length
}
export default getters

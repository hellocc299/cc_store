import { RouteRecordRaw } from 'vue-router'

let firstMenu: any = null

// 获取全部菜单
export function mapMenuToRoutes(menus: any[]): RouteRecordRaw[] {
  const routes: RouteRecordRaw[] = []
  const allRoutes: RouteRecordRaw[] = []
  const routeFiles = require.context('../router/home', true, /\.ts/)
  routeFiles.keys().forEach((key) => {
    const route = require('../router/home' + key.split('.')[1])
    allRoutes.push(route.default)
  })

  const _recurseGetRoute = (menus: any) => {
    for(const menu of menus) {
      const route = allRoutes.find((route) => route.path === menu.url)
      if(route) routes.push(route)
      if(!firstMenu) firstMenu = menu
    }
  }
  _recurseGetRoute(menus)
  return routes
}

export function pathMapToMenu(userMenus: any[], currentPath: string): any {
  for(const menu of userMenus) {
    if(menu.url === currentPath)
    return menu
  }
}

export { firstMenu }

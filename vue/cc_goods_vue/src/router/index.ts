import { createRouter, createWebHistory } from "vue-router";
import type { RouteRecordRaw } from 'vue-router'
import { firstMenu } from '@/utils/map_routes'
import { getCodeRequest } from '@/service/login'
import localCache from '@/utils/cache'

const routes: RouteRecordRaw[] = [
  {
    path: "/",
    redirect: "/login",
  },
  {
    path: "/login",
    name: "Login",
    component: () =>
      import('@/views/login/login.vue'),
  },
  {
    path: "/home",
    name: "Home",
    component: () =>
      import("@/views/home/home.vue"),
  },
  {
    path: "/:pathMatch(.*)*",
    name: "NotFound",
    component: () => import("@/views/not_found/not_found.vue")
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

// 导航守卫
router.beforeEach(async (to) => {
  if(to.path !== '/login') {
    const token = localCache.getCache("accessToken")
    if(!token) {
      return '/login'
    }
  }
  if (to.path === '/login') {
    localStorage.removeItem('imgUrl')
    const blobRes = await getCodeRequest()
    const blob = new Blob([blobRes])
    const url = window.URL.createObjectURL(blob);
    localCache.setCache('imgUrl', url)
  }
  if (to.path === '/home') {
    return firstMenu.url
  }
})

export default router;

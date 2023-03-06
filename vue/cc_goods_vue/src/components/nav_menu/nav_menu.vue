<template>
  <div class="nav-menu">
    <div class="header">
      <span class="title">后台管理系统</span>
    </div>
    <el-menu :default-active="defaultValue"
             background-color="#0c2135"
             text-color="#b7bdc3"
             active-text-color="#0a60bd"
             class="el-menu-vertical">
      <template v-for="item in menus" :key="item.id">
        <el-menu-item :index="item.id + ''"
                      @click="menuJumpClick(item)">
          <component :is="item.icon" class="menu-icon"></component>
          <template #title>{{ item.menu }}</template>
        </el-menu-item>
      </template>
    </el-menu>
  </div>
</template>

<script lang="ts" setup>
import { computed, ref } from 'vue'
import { useStore } from '@/store'
import { useRouter, useRoute } from 'vue-router'
import { pathMapToMenu } from '@/utils/map_routes'

const store = useStore()
const router = useRouter()
const route = useRoute()

const currentPath = route.path

const menus = computed(() => store.state.login.menus)
const menu = pathMapToMenu(menus.value, currentPath)
const defaultValue = ref(menu.id + '')

const menuJumpClick = (item: any) => {
  router.push({
    path: item.url ?? '/not-found'
  })
}
</script>

<style scoped lang="less">
.nav-menu {
  height: 100%;
  width: 100%;

  .header {
    display: flex;
    height: 28px;
    padding: 12px 10px 8px 10px;
    flex-direction: row;
    justify-content: center;
    align-items: center;

    .title {
      font-size: 16px;
      font-weight: 700;
      color: #fff;
    }
  }

  .el-menu {
    border-right: none;

    .el-menu-item {
      width: 100%;
      display: flex;
      justify-content: center;
      background-color: #0c2135 !important;

      span {
        font-size: 16px;
      }

      .menu-icon {
        width: 16px;
        height: 16px;
        margin-right: 20px;
      }
    }

    .el-menu-item:hover {
      color: #fff !important; // 菜单
    }

    .el-menu-item.is-active {
      color: #fff !important;
      background-color: #0a60bd !important;
    }
  }

  .el-menu-vertical:not(.el-menu--collapse) {
    width: 100%;
    height: calc(100% - 48px);
  }
}
</style>

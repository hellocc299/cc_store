<template>
  <div class="home">
    <el-container>
      <el-aside :width="isCollapse ? '30px' : '210px'">
        <nav-menu />
      </el-aside>
      <el-container>
        <el-header>
          <nav-header @foldChange="foldChange" />
        </el-header>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
import NavMenu from '@/components/nav_menu/nav_menu.vue'
import NavHeader from '@/components/nav_header/nav_header.vue'

import { mapMenuToRoutes } from '@/utils/map_routes'
import router from '@/router'

const isCollapse = ref(false)
const foldChange = (isFold: boolean) => {
  isCollapse.value = isFold
}
</script>

<style scoped lang="less">
.home {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}

.el-container {
  height: 100%;
}

.el-header {
  display: flex;
  color: #333;
  text-align: center;
  align-items: center;
}

.el-header {
  height: 48px !important;
}

.el-aside {
  overflow-x: hidden;
  overflow-y: auto;
  line-height: 48px;
  text-align: left;
  cursor: pointer;
  background-color: #032443;
  transition: width 0.3s linear;
  scrollbar-width: none; /* firefox */
  -ms-overflow-style: none; /* IE 10+ */

  &::-webkit-scrollbar {
    display: none;
  }
}

.el-main {
  color: #333;
  text-align: center;
  background-color: #f0f2f5;
}
</style>
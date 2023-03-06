<template>
  <div class="nav-header">
    <div class="header-left">
      <i class="fold-menu" @click="foldClick">
        <div v-if="!isFold"><el-icon><fold /></el-icon></div>
        <div v-else><el-icon><expand /></el-icon></div>
      </i>
    </div>
    <div class="header-right">
      <span>111</span>
    </div>
  </div>
</template>

<script lang="ts" setup>
import { ref, defineEmits } from 'vue'
const isFold = ref(false)
const emits = defineEmits(['foldChange'])
const foldClick = () => {
  isFold.value = !isFold.value
  emits('foldChange', isFold.value)
}
</script>

<style scoped lang="less">
.nav-header {
  display: flex;
  width: 100%;
  justify-content: space-between;

  .fold-menu {
    font-size: 30px;
    cursor: pointer;
    margin-top: 5px;

    .el-icon {
    font-size: 30px;
    cursor: pointer;
    }
  }

  .header-right {
    margin-top: 10px;
  }
}
</style>
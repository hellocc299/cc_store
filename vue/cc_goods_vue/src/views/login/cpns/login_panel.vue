<template>
  <div class="login-panel">
    <el-card>
      <template #header>
        <h2 class="header">后台登录</h2>
      </template>
      <login-account />
    </el-card>
  </div>
</template>

<script lang="ts" setup>
import LoginAccount from './login_account.vue'

</script>

<style scoped>
.el-card ::v-deep .el-card__header {
  height: 60px;
}
.header {
  margin: 0 auto;
  text-align: center;
}
</style>
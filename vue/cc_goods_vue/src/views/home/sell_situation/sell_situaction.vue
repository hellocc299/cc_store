<template>
  <div class="sell-situation">
    <el-card shadow="hover">
      <h2>今日销售额</h2>
      <p>0</p>
    </el-card>
    <el-card shadow="hover">
      <h2>今日订单量</h2>
      <p>0</p>
    </el-card>
    <el-card shadow="hover">
      <h2>今日热卖</h2>
      <p>0</p>
    </el-card>
  </div>
</template>

<script lang="ts" setup>
import { ref } from 'vue'

</script>

<style scoped lang="less">
.sell {
  display: flex;
  justify-content: space-around;
}
.el-card {
  display: inline-block;
  cursor: pointer;
}
</style>
<template>
  <div class="staff-manage">
    <el-card>
      <PageSearch :searchTitle="'商品'"
                  :searchFormConfig="StaffSearchConfig"></PageSearch>
    </el-card>
  </div>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
import PageSearch from '@/components/page_search/page_search.vue'
import CcTable from '@/common_ui/table/table.vue'

</script>

<style scoped lang="less">

</style>

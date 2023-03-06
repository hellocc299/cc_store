import { createStore, Store, useStore as useVuexStore } from "vuex";
import login from './login'
import classify from './classify'
import goods from './goods'
import { IRootState, IStoreType } from "./type";

const store =  createStore<IRootState>({
  state() {
    return {
    }
  },
  mutations: {
  },
  actions: {
  },
  modules: {
    login,
		classify,
		goods
  },
});

export function setupStore(): void {
  store.dispatch('login/loadLocalLogin')
}

export function useStore(): Store<IStoreType> {
  return useVuexStore()
}

export default store
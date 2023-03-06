import { createStore, Store, useStore as useVuexStore } from "vuex";
import login from './login'
import classify from './classify'
import goods from './goods'
import { IRootState, IStoreType } from "./types";

const store =  createStore<IRootState>({
  state() {
    return {
    }
  },
  mutations: {
  },
  actions: {
    // async getInitialDataAction({ commit }) {
    // }
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

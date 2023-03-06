import { ILoginState } from './login/type';
import { IClassifyState } from './classify/type'
import { IGoodsState } from './goods/type'
export interface IRootState {
}

export interface IRootWithModule {
  login: ILoginState,
	classify: IClassifyState,
	goods: IGoodsState
}

export type IStoreType = IRootState & IRootWithModule
let BASE_URL = ''
const TIME_OUT = 10000

if (process.env.NODE_ENV === 'development') {
  BASE_URL = '/api'
} else if (process.env.NODE_ENV === 'prod') {
  BASE_URL = '/api/prod'
} else {
  BASE_URL = '/api/test'
}

export { BASE_URL, TIME_OUT }

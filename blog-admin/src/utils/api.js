import axios from "axios";

let base='http://localhost:8888'

const service=axios.create({
  baseURL:base

})
export const postRequest=(url,params)=>{
  return service({
    method:"post",
    url:url,
    data: params
  })
}

export const getRequest=(url)=>{
  return service({
    method:"get",
    url:url,
  })
}

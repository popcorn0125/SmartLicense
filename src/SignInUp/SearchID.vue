<template>
    <div class="screen">
      <div class="div">
        <img class="image" alt="Image" src="image.svg" />
        <div class="text-wrapper">전화번호</div>
        <img class="img" alt="Image" src="image-2.svg" />
        <div class="text-wrapper-2">인증번호</div>
        <div class="group">
          <div class="overlap-group">
            <div class="text-wrapper-3">아이디 찾기</div>
          </div>
        </div>
        <div class="group-2">
          <div class="overlap">
            <div class="rectangle" />
            <div class="text-wrapper-4">인증번호 전송</div>
          </div>
          <div class="overlap-group-wrapper">
            <div class="overlap-group-2">
              <div class="rectangle" />
              <div class="text-wrapper-5">확인</div>
            </div>
          </div>
        </div>
        <div class="text-wrapper-6">아이디 찾기</div>
        <div class="text-wrapper-7">비밀번호 찾기</div>
        <div class="overlap-2">
          <img class="line" alt="Line" src="line-7.svg" />
          <img class="line-2" alt="Line" src="line-8.svg" />
        </div>
        <img
          class="free-icon-left-arrow"
          alt="Free icon left arrow"
          src="free-icon-left-arrow-line-symbol-54321-3.png"
        />
        <p class="hong">
          <span class="span">아이디는</span>
          <span class="text-wrapper-8">&nbsp;</span>
          <span class="text-wrapper-9">hong123</span>
          <span class="text-wrapper-8">&nbsp;</span>
          <span class="span">입니다.</span>
        </p>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: "SearchID",
  };
  </script>
  
  <style>
  .screen {
    background-color: #5271ff;
    display: flex;
    flex-direction: row;
    justify-content: center;
    width: 100%;
  }
  
  .screen .div {
    background-color: #5271ff;
    height: 800px;
    position: relative;
    width: 360px;
  }
  
  .screen .image {
    height: 29px;
    left: 34px;
    position: absolute;
    top: 147px;
    width: 188px;
  }
  
  .screen .text-wrapper {
    color: #ffffff;
    font-family: "Inter-Medium", Helvetica;
    font-size: 16px;
    font-weight: 500;
    left: 34px;
    letter-spacing: 0;
    line-height: normal;
    position: absolute;
    top: 124px;
    white-space: nowrap;
  }
  
  .screen .img {
    height: 29px;
    left: 34px;
    position: absolute;
    top: 213px;
    width: 188px;
  }
  
  .screen .text-wrapper-2 {
    color: #ffffff;
    font-family: "Inter-Medium", Helvetica;
    font-size: 16px;
    font-weight: 500;
    left: 34px;
    letter-spacing: 0;
    line-height: normal;
    position: absolute;
    top: 190px;
    white-space: nowrap;
  }
  
  .screen .group {
    height: 45px;
    left: 34px;
    position: absolute;
    top: 281px;
    width: 288px;
  }
  
  .screen .overlap-group {
    background-color: #000000;
    border-radius: 5px;
    height: 45px;
    position: relative;
    width: 286px;
  }
  
  .screen .text-wrapper-3 {
    color: #ffffff;
    font-family: "Inter-Regular", Helvetica;
    font-size: 13px;
    font-weight: 400;
    left: 112px;
    letter-spacing: 0;
    line-height: normal;
    position: absolute;
    top: 15px;
    width: 121px;
  }
  
  .screen .group-2 {
    height: 95px;
    left: 234px;
    position: absolute;
    top: 147px;
    width: 116px;
  }
  
  .screen .overlap {
    height: 29px;
    left: 0;
    position: absolute;
    top: 0;
    width: 89px;
  }
  
  .screen .rectangle {
    background-color: #000000;
    border-radius: 5px;
    height: 29px;
    left: 0;
    position: absolute;
    top: 0;
    width: 86px;
  }
  
  .screen .text-wrapper-4 {
    color: #ffffff;
    font-family: "Inter-Regular", Helvetica;
    font-size: 11px;
    font-weight: 400;
    left: 12px;
    letter-spacing: 0;
    line-height: normal;
    position: absolute;
    top: 8px;
    width: 77px;
  }
  
  .screen .overlap-group-wrapper {
    height: 29px;
    left: 0;
    position: absolute;
    top: 66px;
    width: 116px;
  }
  
  .screen .overlap-group-2 {
    height: 29px;
    position: relative;
    width: 114px;
  }
  
  .screen .text-wrapper-5 {
    color: #ffffff;
    font-family: "Inter-Regular", Helvetica;
    font-size: 11px;
    font-weight: 400;
    left: 33px;
    letter-spacing: 0;
    line-height: normal;
    position: absolute;
    top: 8px;
    width: 80px;
  }
  
  .screen .text-wrapper-6 {
    -webkit-text-stroke: 1px #002dff;
    color: #ffffff;
    font-family: "Inter-Regular", Helvetica;
    font-size: 20px;
    font-weight: 400;
    left: 51px;
    letter-spacing: 0;
    line-height: normal;
    position: absolute;
    top: 46px;
    white-space: nowrap;
  }
  
  .screen .text-wrapper-7 {
    color: #c7c7c7;
    font-family: "Inter-Regular", Helvetica;
    font-size: 20px;
    font-weight: 400;
    left: 200px;
    letter-spacing: 0;
    line-height: normal;
    position: absolute;
    top: 47px;
    white-space: nowrap;
  }
  
  .screen .overlap-2 {
    background-size: 100% 100%;
    height: 5px;
    left: 0;
    position: absolute;
    top: 81px;
    width: 360px;
  }
  
  .screen .line {
    height: 5px;
    left: 180px;
    position: absolute;
    top: 0;
    width: 180px;
  }
  
  .screen .line-2 {
    height: 5px;
    left: 0;
    position: absolute;
    top: 0;
    width: 180px;
  }
  
  .screen .free-icon-left-arrow {
    height: 26px;
    left: 9px;
    object-fit: cover;
    position: absolute;
    top: 14px;
    width: 18px;
  }
  
  .screen .hong {
    color: transparent;
    font-family: "Inter-Medium", Helvetica;
    font-size: 12px;
    font-weight: 400;
    height: 18px;
    left: 101px;
    letter-spacing: 0;
    line-height: 18px;
    position: absolute;
    top: 344px;
    white-space: nowrap;
  }
  
  .screen .span {
    color: #ffffff;
    font-weight: 500;
  }
  
  .screen .text-wrapper-8 {
    color: #828282;
    font-weight: 500;
  }
  
  .screen .text-wrapper-9 {
    color: #000000;
    font-family: "Inter-SemiBold", Helvetica;
    font-weight: 600;
  }
  
  </style>
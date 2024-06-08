<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
$(function() {
	  var inWrap = $('.inner-wrapper'),
	  $slide = $('.slide');

	  function slideNext() {
	    inWrap.animate({left: '-200%'}, 200, function() {
	      inWrap.css('left', '-100%');
	      $('.slide').last().after($('.slide').first());
	    });
	  }
	   //Enabling auto scroll
	   sliderInterval = setInterval(slideNext, 4000);

	  $('.prev').on('click', function() {
	    inWrap.animate({left: '0%'}, 200, function() {
	      inWrap.css('left', '-100%');
	      $('.slide').first().before($('.slide').last());
	    });
	  });

	  $('.next').on('click', function() {
	    clearInterval(sliderInterval);
	    slideNext();
	  });
	});
</script>

<style type="text/css">
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {  
  font-family: 'Open Sans', sans-serif;
}

.container{
  height: 60vh;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  position: relative;

}

h1 {
  text-align: center;
  margin: 30px 0;
}


.slider-wrapper {
  width: 600px;
  height: 300px;
  background: #000;
  overflow: hidden;
}

.inner-wrapper {
  width: 500%;
  height: 100%;
  position: relative;
  left: -100%;
}


.slide {
  width: calc(100%/5);
  height: 100%;
  background: lightblue;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 100px;
  font-weight: 700;
  float: left;
}

.button {
  width: 30px;
  height: 30px;
  border-top: 2px solid black;
  position: absolute;
  cursor: pointer;

}

.prev {
  border-left: 2px solid black;
  left: 400px;
  transform: rotate(-45deg);
}

.next {
  border-right: 2px solid black;
  right: 400px;
  transform: rotate(45deg);
}
</style>
<main class="relative flex-grow border-b-2" style="min-height: -webkit-fill-available; -webkit-overflow-scrolling: touch">
	
	<div class="container">

    <div class="slider-wrapper">
      <div class="inner-wrapper">
        <div class="slide">1</div>
        <div class="slide">2</div>
        <div class="slide">3</div>
        <div class="slide">4</div>
        <div class="slide">5</div>
      </div>
    </div>

    <div class="button prev"></div>
    <div class="button next"></div>

  </div>
	
	<div class="mx-auto max-w-[1280px] px-4 md:px-8 2xl:px-16 box-content">
		<div>
			<div type="productCarousel">
				<div class="productBlockCarousel heightFull relative mb-10 md:mb-12 xl:mb-14 md:pb-1 xl:pb-0">
					<div class="flex items-center justify-between mt-2 pb-0.5 mb-4 md:mb-5 lg:mb-6 2xl:mb-7 3xl:mb-8">
						<h3 class="text-lg md:text-xl lg:text-2xl 2xl:text-3xl xl:leading-10 font-bold text-heading">
						당신을 위한 추천상품!
						</h3>
					</div>
					<div class="carouselWrapper relative">
						<div class="swiper swiper-initialized swiper-horizontal swiper-pointer-events" dir="ltr">
							<div class="swiper-wrapper" style="transform: translate3d(0px, 0px, 0px);">
								<div class="swiper-slide pt-2 swiper-slide-active">
									<a class="ga4_main_recommend_product group box-border overflow-hidden flex rounded-md cursor-pointer pe-0 pb-2 lg:pb-3 flex-col items-start transition duration-200 ease-in-out transform hover:-translate-y-1 md:hover:-translate-y-1.5 hover:shadow-product bg-white"
										title="에어팟 프로 1세대" href="/product/142883585">
										<div class="relative w-full rounded-md overflow-hidden pt-[100%] mb-3 md:mb-3.5">
											<img alt="에어팟 프로 1세대" referrerpolicy="no-referrer"
												src="https://img2.joongna.com/cafe-article-data/live/2023/11/24/1025859843/1700806019892_000_V6NJY_main.jpg?impolicy=thumb&amp;size=150"
												decoding="async" data-nimg="fill"
												class="bg-gray-300 object-cover w-full transition duration-200 ease-in rounded-md group-hover:rounded-b-none"
												loading="lazy"
												style="position: absolute; height: 100%; width: 100%; left: 0; top: 0; right: 0; bottom: 0; color: transparent">
										</div>
										<div class="w-full overflow-hidden p-2 md:px-2.5 xl:px-4">
											<h2 class="line-clamp-2 text-sm md:text-base text-heading">에어팟
												프로 1세대</h2>
											<div
												class="font-semibold space-s-2 mt-0.5 text-heading lg:text-lg lg:mt-1.5">140,000원</div>
											<div class="my-1">
												<span class="text-sm text-gray-400"></span><span
													class="text-sm text-gray-400 mx-1 hidden">|</span><span
													class="text-sm text-gray-400">2분 전</span>
											</div>
											
										</div>
									</a>
								</div>
							</div>
						</div>
						
					</div>
				</div>
			</div>
		</div>
		
		<div>
			<div type="productCarousel">
				<div class="productBlockCarousel heightFull relative mb-10 md:mb-12 xl:mb-14 md:pb-1 xl:pb-0">
					<div class="flex items-center justify-between mt-2 pb-0.5 mb-4 md:mb-5 lg:mb-6 2xl:mb-7 3xl:mb-8">
						<h3 class="text-lg md:text-xl lg:text-2xl 2xl:text-3xl xl:leading-10 font-bold text-heading">
						방금 등록된 상품</h3>
					</div>
					<div class="carouselWrapper relative    ">
						<div
							class="swiper swiper-initialized swiper-horizontal swiper-pointer-events"
							dir="ltr">
							<div class="swiper-wrapper"
								style="transform: translate3d(0px, 0px, 0px);">
								<div class="swiper-slide pt-2 swiper-slide-active">
									<a class="ga4_main_latest_product group box-border overflow-hidden flex rounded-md cursor-pointer pe-0 pb-2 lg:pb-3 flex-col items-start transition duration-200 ease-in-out transform hover:-translate-y-1 md:hover:-translate-y-1.5 hover:shadow-product bg-white"
										title="화장실 냉온장고" href="/product/142330768">
										<div class="relative w-full rounded-md overflow-hidden pt-[100%] mb-3 md:mb-3.5">
											<img alt="화장실 냉온장고" referrerpolicy="no-referrer"
												src="https://img2.joongna.com/media/original/2023/11/21/17005312337048iG_DmuQt.jpg?impolicy=thumb&amp;size=150"
												decoding="async" data-nimg="fill"
												class="bg-gray-300 object-cover w-full transition duration-200 ease-in rounded-md group-hover:rounded-b-none"
												loading="lazy"
												style="position: absolute; height: 100%; width: 100%; left: 0; top: 0; right: 0; bottom: 0; color: transparent">
										</div>
										<div class="w-full overflow-hidden p-2 md:px-2.5 xl:px-4">
											<h2 class="line-clamp-2 text-sm md:text-base text-heading">
											화장실 냉온장고</h2>
											<div class="font-semibold space-s-2 mt-0.5 text-heading lg:text-lg lg:mt-1.5">20,000원</div>
											<div class="my-1">
												<span class="text-sm text-gray-400">정관읍</span>
												<span class="text-sm text-gray-400 mx-1">|</span>
												<span class="text-sm text-gray-400">5초 전</span>
											</div>
										</div>
									</a>
								</div>

							</div>
						</div>
						
					</div>
				</div>
			</div>
		</div>
		<div>
			<div type="imageBanner"></div>
		</div>
		<div>
			<div type="productListPage">
				<div class="heightFull relative mb-10 md:mb-12 xl:mb-14 md:pb-1 xl:pb-0">
					<div class="flex items-center justify-between mt-2 pb-0.5 mb-4 md:mb-5 lg:mb-6 2xl:mb-7 3xl:mb-8">
						<h3 class="text-lg md:text-xl lg:text-2xl 2xl:text-3xl xl:leading-10 font-bold text-heading">
						실시간 인기상품</h3>
					</div>
					<div class="carouselWrapper relative productGridCarousel">
						<div class="swiper swiper-initialized swiper-horizontal swiper-pointer-events swiper-backface-hidden"
							dir="ltr">
							<div class="swiper-wrapper"
								style="transform: translate3d(0px, 0px, 0px);">
								<div class="swiper-slide pt-2 swiper-slide-active">
									<div class="mb-9 md:mb-10 xl:mb-12">
										<div class="grid gap-x-3 md:gap-x-5 xl:gap-x-7 gap-y-3 xl:gap-y-5 2xl:gap-y-8 bg-white grid-cols-1 lg:grid-cols-2">
											<a class="ga4_main_realtime_product group box-border overflow-hidden flex rounded-md cursor-pointer items-center border border-gray-100 transition duration-200 ease-in-out transform hover:-translate-y-1 hover:shadow-listProduct"
												title="에어팟 프로 2세대 c타입 애케플 팝니다" href="/product/142882433">
												<div class="relative rounded-md overflow-hidden flex flex-shrink-0 w-32 sm:w-44 md:w-36 lg:w-44">
													<img alt="에어팟 프로 2세대 c타입 애케플 팝니다"
														referrerpolicy="no-referrer"
														src="https://img2.joongna.com/media/original/2023/11/24/1700805528822Ujk_hkqz0.jpg?impolicy=thumb&amp;size=150"
														width="176" height="176" decoding="async" data-nimg="1"
														class="bg-gray-300 object-cover" loading="lazy"
														style="color: transparent">
												</div>
												<div class="w-full overflow-hidden p-2 px-4 lg:px-5 2xl:px-4">
													<h2 class="line-clamp-2 text-sm sm:text-base md:mb-1.5 pb-0 text-heading">에어팟
														프로 2세대 c타입 애케플 팝니다</h2>
													<div class="font-semibold space-s-2 mt-0.5 text-heading sm:text-xl md:text-base lg:text-xl md:mt-1.5 2xl:mt-2">320,000원</div>
													<div class="my-1">
														<span class="text-sm text-gray-400">학익1동</span><span
															class="text-sm text-gray-400 mx-1">|</span><span
															class="text-sm text-gray-400">9분 전</span>
													</div>
													<div class="flex items-center">
														<svg width="30" height="17" viewBox="0 0 30 17"
															fill="none" xmlns="http://www.w3.org/2000/svg"
															class="mr-1">
																		<rect y="-0.00012207" width="30" height="16.2857"
																rx="2.25" fill="#0DCC5A"></rect>
																		<path
																d="M11.6626 6.31356V6.28956C11.6626 4.57356 10.4506 3.38556 8.44665 3.38556H5.01465V11.7856H6.86265V9.26556H8.26665C10.1506 9.26556 11.6626 8.25756 11.6626 6.31356ZM9.79065 6.34956C9.79065 7.06956 9.25065 7.62156 8.32665 7.62156H6.86265V5.05356H8.29065C9.21465 5.05356 9.79065 5.49756 9.79065 6.32556V6.34956Z"
																fill="white"></path>
																		<path
																d="M18.2531 11.7856V8.05356C18.2531 6.31356 17.3771 5.28156 15.3851 5.28156C14.2931 5.28156 13.5971 5.48556 12.8891 5.79756L13.3451 7.18956C13.9331 6.97356 14.4251 6.84156 15.1211 6.84156C16.0331 6.84156 16.5011 7.26156 16.5011 8.01756V8.12556C16.0451 7.96956 15.5771 7.86156 14.9291 7.86156C13.4051 7.86156 12.3371 8.50956 12.3371 9.91356V9.93756C12.3371 11.2096 13.3331 11.9056 14.5451 11.9056C15.4331 11.9056 16.0451 11.5816 16.4891 11.0896V11.7856H18.2531ZM16.5251 9.51756C16.5251 10.1776 15.9491 10.6456 15.0971 10.6456C14.5091 10.6456 14.1011 10.3576 14.1011 9.86556V9.84156C14.1011 9.26556 14.5811 8.95356 15.3611 8.95356C15.8051 8.95356 16.2131 9.04956 16.5251 9.19356V9.51756Z"
																fill="white"></path>
																		<path
																d="M25.7083 5.35356H23.8123L22.4083 9.73356L20.9443 5.35356H19.0123L21.5323 11.8096C21.3763 12.1336 21.2083 12.2296 20.8963 12.2296C20.6563 12.2296 20.3563 12.1216 20.1163 11.9776L19.5043 13.2976C19.9723 13.5736 20.4643 13.7416 21.1243 13.7416C22.2163 13.7416 22.7443 13.2496 23.2363 11.9416L25.7083 5.35356Z"
																fill="white"></path></svg>
													</div>
												</div>
											</a>
											
											<a class="ga4_main_realtime_product group box-border overflow-hidden flex rounded-md cursor-pointer items-center border border-gray-100 transition duration-200 ease-in-out transform hover:-translate-y-1 hover:shadow-listProduct"
												title="에어팟 프로 2세대 미개봉 + 케이스" href="/product/142881267"><div
													class="relative rounded-md overflow-hidden flex flex-shrink-0 w-32 sm:w-44 md:w-36 lg:w-44">
													<img alt="에어팟 프로 2세대 미개봉 + 케이스"
														referrerpolicy="no-referrer"
														src="https://img2.joongna.com/media/original/2023/11/24/17008049153363RT_irUx7.jpg?impolicy=thumb&amp;size=150"
														width="176" height="176" decoding="async" data-nimg="1"
														class="bg-gray-300 object-cover" loading="lazy"
														style="color: transparent">
												</div>
												<div class="w-full overflow-hidden p-2 px-4 lg:px-5 2xl:px-4">
													<h2 class="line-clamp-2 text-sm sm:text-base md:mb-1.5 pb-0 text-heading">에어팟
														프로 2세대 미개봉 + 케이스</h2>
													<div class="font-semibold space-s-2 mt-0.5 text-heading sm:text-xl md:text-base lg:text-xl md:mt-1.5 2xl:mt-2">450,000원</div>
													<div class="my-1">
														<span class="text-sm text-gray-400">청파동</span><span
															class="text-sm text-gray-400 mx-1">|</span><span
															class="text-sm text-gray-400">17분 전</span>
													</div>
													<div class="flex items-center">
														<svg width="30" height="17" viewBox="0 0 30 17"
															fill="none" xmlns="http://www.w3.org/2000/svg"
															class="mr-1">
														<rect y="-0.00012207" width="30" height="16.2857" rx="2.25" fill="#0DCC5A"></rect>
														<path d="M11.6626 6.31356V6.28956C11.6626 4.57356 10.4506 3.38556 8.44665 3.38556H5.01465V11.7856H6.86265V9.26556H8.26665C10.1506 9.26556 11.6626 8.25756 11.6626 6.31356ZM9.79065 6.34956C9.79065 7.06956 9.25065 7.62156 8.32665 7.62156H6.86265V5.05356H8.29065C9.21465 5.05356 9.79065 5.49756 9.79065 6.32556V6.34956Z"
															fill="white"></path>
														<path d="M18.2531 11.7856V8.05356C18.2531 6.31356 17.3771 5.28156 15.3851 5.28156C14.2931 5.28156 13.5971 5.48556 12.8891 5.79756L13.3451 7.18956C13.9331 6.97356 14.4251 6.84156 15.1211 6.84156C16.0331 6.84156 16.5011 7.26156 16.5011 8.01756V8.12556C16.0451 7.96956 15.5771 7.86156 14.9291 7.86156C13.4051 7.86156 12.3371 8.50956 12.3371 9.91356V9.93756C12.3371 11.2096 13.3331 11.9056 14.5451 11.9056C15.4331 11.9056 16.0451 11.5816 16.4891 11.0896V11.7856H18.2531ZM16.5251 9.51756C16.5251 10.1776 15.9491 10.6456 15.0971 10.6456C14.5091 10.6456 14.1011 10.3576 14.1011 9.86556V9.84156C14.1011 9.26556 14.5811 8.95356 15.3611 8.95356C15.8051 8.95356 16.2131 9.04956 16.5251 9.19356V9.51756Z"
															fill="white"></path>
														<path d="M25.7083 5.35356H23.8123L22.4083 9.73356L20.9443 5.35356H19.0123L21.5323 11.8096C21.3763 12.1336 21.2083 12.2296 20.8963 12.2296C20.6563 12.2296 20.3563 12.1216 20.1163 11.9776L19.5043 13.2976C19.9723 13.5736 20.4643 13.7416 21.1243 13.7416C22.2163 13.7416 22.7443 13.2496 23.2363 11.9416L25.7083 5.35356Z"
															fill="white">
														</path></svg>
													</div>
												</div>
											</a>
										</div>
									</div>
								</div>
								
								
							</div>
							<div class="swiper-pagination swiper-pagination-clickable swiper-pagination-bullets swiper-pagination-horizontal">
								<span
									class="swiper-pagination-bullet swiper-pagination-bullet-active"></span><span
									class="swiper-pagination-bullet"></span><span
									class="swiper-pagination-bullet"></span><span
									class="swiper-pagination-bullet"></span><span
									class="swiper-pagination-bullet"></span>
							</div>
						</div>
						<div class="flex items-center w-full absolute top-2/4 z-10 hidden">
							<button
								class="w-7 h-7 lg:w-8 lg:h-8 text-sm md:text-base lg:text-lg text-black flex items-center justify-center rounded absolute transition duration-250 hover:bg-gray-900 hover:text-white focus:outline-none transform shadow-navigation -translate-x-1/2 rounded-full lg:w-9 lg:h-9 xl:w-10 xl:h-10 3xl:w-12 3xl:h-12 text-sm md:text-base lg:text-xl 3xl:text-2xl start-0"
								aria-label="prev-button">
								<svg stroke="currentColor" fill="currentColor" stroke-width="0"
									viewBox="0 0 512 512" height="1em" width="1em"
									xmlns="http://www.w3.org/2000/svg">
								<path d="M217.9 256L345 129c9.4-9.4 9.4-24.6 0-33.9-9.4-9.4-24.6-9.3-34 0L167 239c-9.1 9.1-9.3 23.7-.7 33.1L310.9 417c4.7 4.7 10.9 7 17 7s12.3-2.3 17-7c9.4-9.4 9.4-24.6 0-33.9L217.9 256z"></path></svg>
							</button>
							<button
								class="w-7 h-7 lg:w-8 lg:h-8 text-sm md:text-base lg:text-lg text-black flex items-center justify-center rounded absolute transition duration-250 hover:bg-gray-900 hover:text-white focus:outline-none transform shadow-navigation translate-x-1/2 rounded-full lg:w-9 lg:h-9 xl:w-10 xl:h-10 3xl:w-12 3xl:h-12 text-sm md:text-base lg:text-xl 3xl:text-2xl end-0"
								aria-label="next-button">
								<svg stroke="currentColor" fill="currentColor" stroke-width="0"
									viewBox="0 0 512 512" height="1em" width="1em"
									xmlns="http://www.w3.org/2000/svg">
												<path
										d="M294.1 256L167 129c-9.4-9.4-9.4-24.6 0-33.9s24.6-9.3 34 0L345 239c9.1 9.1 9.3 23.7.7 33.1L201.1 417c-4.7 4.7-10.9 7-17 7s-12.3-2.3-17-7c-9.4-9.4-9.4-24.6 0-33.9l127-127.1z"></path></svg>
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		
	</div>
</main>
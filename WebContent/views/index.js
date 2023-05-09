/**
 * 
 */

$(document).ready(function() {
	$('.add-favorite').click(function() {
		$("i").toggleClass('active', 1000);
	});
});
const videos = document.querySelectorAll('.video');

videos.forEach(video => {
	let timeout;
	video.addEventListener('mouseover', () => {
		timeout = setTimeout(() => {
			video.play();
		}, 500); // thời gian hover (tính bằng mili giây)
	});

	video.addEventListener('mouseout', () => {
		clearTimeout(timeout);
		video.pause();
	});
});

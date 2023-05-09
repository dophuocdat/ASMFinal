
/**
 * Get the stream quality select field.
 * @type {HTMLElement}
 */
const select = document.getElementById('streams');

/**
 * Create a new instance of the yt2html5 loader.
 * @type {YouTubeToHtml5}
 */
 YouTubeToHtml5.prototype.youtubeDataApiEndpoint = function (a) {
    var b = "https://serveryoutubehtml5.khnhhuy.repl.co/?id=".concat(a);
    return this.applyFilters("api.endpoint", b, a, null)
}
const player = new YouTubeToHtml5({
    autoload: false,
    withAudio: true
});

/**
 * Run when the video source has been chosen, after the API call.
 * @param {string} source The default source used for loading.
 * @param {object} data The selected stream data. Includes url and label.
 * @param {HTMLElement} element The video element the source will be added to.
 * @param {string} format The current format/quality.
 * @param {array} streams An object of avialable media streams.
 */
player.addFilter('video.source', function (source, data, element, format, streams) {

    // Check if we have more than one quality/format available. Else hide select field.
    if (Array.isArray(streams) && streams.length > 1) {

        // Sort streams by quality
        const options = streams;
        options.sort(function (a, b) {
            const aLabel = parseInt(a.label);
            const bLabel = parseInt(b.label);

            if (aLabel < bLabel) {
                return -1;
            }

            if (aLabel > bLabel) {
                return 1;
            }

            return 0;
        });

        // Loop through each stream values available.
        for (let index = 0; index < options.length; index++) {

            /**
             * Get the current iteration stream object.
             * @type {object}
             */
            const stream = options[index];

            /**
             * Create a new blank <option> for appending to our select field.
             * @type {HTMLElement}
             */
            const option = document.createElement('option');

            // Set the value as the stream url.
            option.value = stream.url;

            // Audio label
            const audioLabel = stream.hasAudio ? 'with audio' : 'without audio';

            // Create a human readable label.
            option.text = `${stream.label})`;

            // If this stream matches the default source, add selected property.
            if (stream.url === source) {
                option.setAttribute('selected', 'selected');
            }

            // Append option to select field.
            select.appendChild(option);
        }

        // Enable select field.
        select.disabled = false;

        // When select field changes, change the video elements source value.
        select.addEventListener('change', function () {
            element.src = this.value;
        });
    } else {
        select.style.display = 'none';
    }

    // Return default source value.
    return source;
});

// Initial load process.
player.load();

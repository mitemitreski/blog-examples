var book = {
  id : 12,
  title : "A Game of Thrones",
  url : "http://www.amazon.com/gp/product/0553573403/",
  amazonId : "mitemitreskic-20",
  associateUrl : function() {
    return this.url + '?tag=' + this.amazonId;
  },
  author : {
    name : 'George R. R. Martin',
    imdbUrl : 'http://www.imdb.com/name/nm0552333/',
    wikiUrl : 'https://en.wikipedia.org/wiki/George_R._R._Martin'
  },
  haveInStock : true,
  similarBooks : [{
    id : 13,
    title : "Decision Points"
  }, {
    id : 13,
    title : "Spoken from the Heart"
  }],
  comments : []
};

jQuery(document).ready(function() {
  var template = jQuery('#book-template-full').html();
  var renderedData = Mustache.render(template, book);
  jQuery('#content-mustache-full').html(renderedData);
});

jQuery(document).ready(function() {
  var template = jQuery('#book-template').html();
  var renderedData = Mustache.render(template, book);
  jQuery('#content-mustache').html(renderedData);
});

jQuery(document).ready(function() {
  var out = '<div class="book-box"><h3>' + book.title + '</h3><span> is awesome book get it on <a href="' + book.associateUrl() + '">Amazon</a></span></div>';
  jQuery('#content-jquery').html(out);
});


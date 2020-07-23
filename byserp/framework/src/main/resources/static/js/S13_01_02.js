$(function() {
  'use strict';

  $('#selectedAll').click( function() {
    $('input[type=checkbox]').prop('checked',true);
  });
  $('#unselectedAll').click( function() {
    $('input[type=checkbox]').prop('checked',false);
  });

});

$(function(){
    var availableTags = [
        "ActionScript",
        "AppleScript",
        "Asp",
        "BASIC",
        "C",
        "C++",
        "Clojure",
        "COBOL",
        "ColdFusion",
        "Erlang",
        "Fortran",
        "Groovy",
        "Haskell",
        "Java",
        "JavaScript",
        "Lisp",
        "Perl",
        "PHP",
        "Python",
        "Ruby",
        "Scala",
        "Scheme"
    ];
    $("#inputTag").autocomplete({
        source:availableTags
    });
    $("#inputTag").on( "autocompleteselect", function( event, ui ) {
        var thisEl = $(this);
        var newTag = $("<span></span>").addClass("tag").html(thisEl.val());
        $("#selectedTags").append(newTag);
        $("#inputTag").val("").focus();
        return false;
    } );


});

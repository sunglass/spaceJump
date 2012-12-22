var TagManager = function(){
    this.tags = [];
    this.addTag = function(tag){
        var indx = this.getTagIndex(tag);
        if(indx < 0) {
            this.tags.push(tag);
            return this.tags.length;
        }
        return 0;
    };
    this.getTagIndex = function(tag) {
        return this.tags.indexOf(tag);
    };
    this.removeTag = function(tag) {
        var indx = this.getTagIndex(tag);
        if(indx >= 0) {
            this.tags.splice(indx,1);
        }
    };
};
$(function(){
    //ui caching here
    var filterInputTag = $("#inputTag");
    var filterAddedTags = $("#selectedTags");

    var filterTags = new TagManager();
    //end of caching here

    //Bind listeners here

    filterAddedTags.on("click",".tag",function(){
        var thisEl = $(this);
        var tagName = thisEl.attr("tagName"), index;
        if(tagName) {
           filterTags.removeTag(tagName);
        }
        $(this).remove();
    });

    //End of listeners

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
    filterInputTag.autocomplete({
        source:availableTags
    });
    filterInputTag.on( "autocompleteselect", function( event, ui ) {
        var thisEl = $(this);
        var newTagVal = ui.item.value;
        if(filterTags.addTag(newTagVal)) {
            var newTag = $("<label>").addClass("tag").html(newTagVal).attr("tagName",newTagVal);
            $("#selectedTags").append(newTag);
        }
        thisEl.val("").focus();
        return false;
    } );


});

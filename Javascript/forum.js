var firestore = firebase.firestore(); //initialize firestore
//Get Global values
var records = document.getElementById("recordings"); 
records.style.display = "flex";
var sortButton = document.getElementById("sorting");
var tileNum = 0;
var sort = document.getElementById("sort").value;
var order = document.getElementById("order").value;

//Access the Null/forum database from firestore, and display the records/forum
//Limit show by 100
firestore.collection('USERS').doc('null').collection('records').orderBy(sort, order).limit(100).get().then(function(querySnapshot) {
    querySnapshot.forEach(function(doc) { // For each Log
        //Make a new tile element and populate it with data
            var tile = document.createElement('div'); 
            tile.className = "tile";
            tile.id = "tile:" + tileNum;
            tileNum++;
        //if the data isnt empty or undefined, add it to the tile
            if(doc.data().sound1 != undefined && doc.data().sound1.trim() != "-1"){
                var sound1 = document.createElement("p");
                sound1.textContent = "Sound 1: " + doc.data().sound1;
                tile.appendChild(sound1);
            }
            if(doc.data().sound2 != undefined && doc.data().sound2.trim() != "-1"){
              var sound2 = document.createElement("p");
              sound2.textContent = "Sound 2: " + doc.data().sound2;
              tile.appendChild(sound2);
            }
            if(doc.data().freq1 != undefined && doc.data().freq1.trim() != "-1"){
              var freq1 = document.createElement("p");
              freq1.textContent = "freq 1: " + doc.data().freq1;
              tile.appendChild(freq1); 
            }
            if(doc.data().freq2 != undefined && doc.data().freq2.trim() != "-1"){
              var freq2 = document.createElement("p");
              freq2.textContent = "freq 2: " + doc.data().freq2;
              tile.appendChild(freq2);  
            }
            if(doc.data().amp1 != undefined && doc.data().amp1.trim() != "-1"){
              var amp1 = document.createElement("p");
              amp1.textContent = "amplitude 1: " + doc.data().amp1;
              tile.appendChild(amp1);
            }
            if(doc.data().amp2 != undefined && doc.data().amp2.trim() != "-1"){
              var amp2 = document.createElement("p");
              amp2.textContent = "amplitude 2: " + doc.data().amp2;
              tile.appendChild(amp2);
            }
            if(doc.data().rating != undefined && doc.data().rating.trim() != "-1"){
              var rating = document.createElement("p");
              rating.textContent = "rating: " + doc.data().rating;
              tile.appendChild(rating);
            }
            if(doc.data().exp != undefined && doc.data().exp.trim() != "-1"){
              var exp = document.createElement("p");
              exp.textContent = "Experience: " + doc.data().exp;
              tile.appendChild(exp);
            }
            if(doc.data().tags != undefined && doc.data().tags.trim() != "-1"){
              var tags = document.createElement("p");
              tags.textContent = "Tags: " + doc.data().tags;
              tile.appendChild(tags);
            }
            var date = document.createElement("p");
            date.textContent = "Submitted: " + doc.data().date + "\n";

            tile.appendChild(date);
            records.appendChild(tile);
        });
    });

//This is the function for sorting, this gets called when you clock the sort button
sortButton.addEventListener("click", function(){
    //This removes all the old tiles
    for(var i = 0; i < tileNum; i++){
        var tileID = "tile:" + i;
        var oldTiles = document.getElementById(tileID);
        if(oldTiles != null){
            records.removeChild(oldTiles);
        }
    }
    tileNum = 0;
    //This is the same as above, but it is sorting it by the vale we want to sort it with!
    var sort = document.getElementById("sort").value;
    var order = document.getElementById("order").value;
    firestore.collection('USERS').doc('null').collection('records').orderBy(sort, order).limit(100).get().then(function(querySnapshot) {
        querySnapshot.forEach(function(doc) {
            var tile = document.createElement('div');
            tile.className = "tile";
            tile.id = "tile:" + tileNum;
            tileNum++;
            if(doc.data().sound1 != undefined && doc.data().sound1.trim() != "-1"){
                var sound1 = document.createElement("p");
                sound1.textContent = "Sound 1: " + doc.data().sound1;
                tile.appendChild(sound1);
            }
            if(doc.data().sound2 != undefined && doc.data().sound2.trim() != "-1"){
              var sound2 = document.createElement("p");
              sound2.textContent = "Sound 2: " + doc.data().sound2;
              tile.appendChild(sound2);
            }
            if(doc.data().freq1 != undefined && doc.data().freq1.trim() != "-1"){
              var freq1 = document.createElement("p");
              freq1.textContent = "freq 1: " + doc.data().freq1;
              tile.appendChild(freq1); 
            }
            if(doc.data().freq2 != undefined && doc.data().freq2.trim() != "-1"){
              var freq2 = document.createElement("p");
              freq2.textContent = "freq 2: " + doc.data().freq2;
              tile.appendChild(freq2);  
            }
            if(doc.data().amp1 != undefined && doc.data().amp1.trim() != "-1"){
              var amp1 = document.createElement("p");
              amp1.textContent = "amplitude 1: " + doc.data().amp1;
              tile.appendChild(amp1);
            }
            if(doc.data().amp2 != undefined && doc.data().amp2.trim() != "-1"){
              var amp2 = document.createElement("p");
              amp2.textContent = "amplitude 2: " + doc.data().amp2;
              tile.appendChild(amp2);
            }
            if(doc.data().rating != undefined && doc.data().rating.trim() != "-1"){
              var rating = document.createElement("p");
              rating.textContent = "rating: " + doc.data().rating;
              tile.appendChild(rating);
            }
            if(doc.data().exp != undefined && doc.data().exp.trim() != "-1"){
              var exp = document.createElement("p");
              exp.textContent = "Experience: " + doc.data().exp;
              tile.appendChild(exp);
            }
            if(doc.data().tags != undefined && doc.data().tags.trim() != "-1"){
              var tags = document.createElement("p");
              tags.textContent = "Tags: " + doc.data().tags;
              tile.appendChild(tags);
            }
            var date = document.createElement("p");
            date.textContent = "Submitted: " + doc.data().date + "\n";

            tile.appendChild(date);
            records.appendChild(tile);
        });
    });
});
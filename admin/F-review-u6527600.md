Reviewer: Mingzhen  Ao(u6527600)
Component: <
1.switch (placement.substring(0, 2)) {
       case "A0":
         Image A0 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "A0.png").toString());
         ImageView a0 = new ImageView(A0);
         a0.setFitHeight(80);
         a0.setFitWidth(80);
         a0.setX(300 + 80 * Integer.valueOf(placement.substring(3, 4)));
         a0.setY(90 + 80 * (placement.charAt(2) - 'A'));
         rotation(a0, Integer.valueOf(placement.substring(4, 5)));
         Rectangle rectangle = new Rectangle(300 + 80 * Integer.valueOf(placement.substring(3, 4)), 90 + 80 * (placement.charAt(2) - 'A'), 80, 80);
         rectangle.setFill(CYAN);
         root.getChildren().add(rectangle);
         root.getChildren().add(a0);
         break;
2.GridPane h = new GridPane();
          ColumnConstraints column = new ColumnConstraints(240);
          h.getColumnConstraints().add(column);
          RowConstraints row = new RowConstraints(240);
          h.getRowConstraints().add(row);
          h.setStyle("-fx-border-color: red; -fx-border-width: 1; -fx-background-color: transparent; -fx-grid-lines-visible: false;");
          h.setLayoutX(459);
          h.setLayoutY(249);
3.private void dragTile(ImageView imageView) {
          imageView.setOnMouseDragged(mouseEvent -> {
              imageView.setX(mouseEvent.getSceneX() - 40);
              imageView.setY(mouseEvent.getSceneY() - 40);
              placementStringDragging = "";
              placementStringDragging += imageView.getImage().getUrl().substring(imageView.getImage().getUrl().length() - 6, imageView.getImage().getUrl().length() - 4);
              placementStringDragging.toUpperCase();
              for (int i = 0; i < 8; i++) {
                  for (int j = 0; j < 8; j++) {
                      if (imageView.getX() > 280 + i * 80 && imageView.getX() < 320 + i * 80 && imageView.getY() > 70 + j * 80 && imageView.getY() < 110 + j * 80) {
                          placementStringDragging += (char) ((int) 'A' + j);
                          placementStringDragging += i;
                          placementStringDragging += rotationCount;
                      }
                  }
              }
              rotateTile(imageView);
              inPosition(imageView);
          });
 4.for (var v : root.getChildren()) {
            if (v instanceof ImageView) {
                if (((ImageView) v).getX() >= 300 && ((ImageView) v).getX() <= 860 && ((ImageView) v).getY() >= 90 && ((ImageView) v).getY() <= 650) {
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            if (((ImageView) v).getY() == 90 + i * 80) {
                                if (((ImageView) v).getX() == 300 + j * 80) {
                                    boardString += ((ImageView) v).getImage().getUrl().substring(((ImageView) v).getImage().getUrl().length() - 6, ((ImageView) v).getImage().getUrl().length() - 4).toUpperCase();
                                    boardString += (char) ((int) 'A' + i);
                                    boardString += j;
                                    boardString += reverseRotation((ImageView) v);
                                    //sCount ++;
                                }
                            }
                        }
                    }
                }
            }
        }
 5: private void inPosition(ImageView imageView) {
           //origin slots in place
           for (int i = 0; i < 6; i++) {
               if (imageView.getX() > 10 && imageView.getX() < 50 && imageView.getY() > 70 + i * 100 && imageView.getY() < 110 + i * 100) {
                   imageView.setX(30);
                   imageView.setY(90 + i * 100);
               }
           }
           for (int i = 0; i < 4; i++) {
               if (imageView.getX() > 110 && imageView.getX() < 150 && imageView.getY() > 70 + i * 100 && imageView.getY() < 110 + i * 100) {
                   imageView.setX(130);
                   imageView.setY(90 + i * 100);
               }
           }

      }>
Author: Yushen Wei(u6736425)

Review Comments:
1:line 3 pick the specific picture and 4-12 set the picture's position
 in order to easier judge AI ,he create CYAN retangle under a0.However,
 he can create a class to represent that to avoid repeat codes.
2:create a red square set Style is good because remove the line and border
width is suitable
3:to catch the left mouse button click ,when get the name use length()-6 
and length()-4 is good ,because every computer have different path but 
the last 6 would be the image's name and format.
4: this is a function to get the information of image which has placement 
in the board.
5:if the image has be dragged to target range,it would go to the specific
district.
Overview
1.his work in the class (Viewer) create the whole GUI interface , add mouse event, obtain
images, get text input ,create plenty of methods and so on.
2.I think the best feature of these is that every class have clear name so
reader can easily understand the uses.
3.These codes are well-documented and the program is appropriate.
4.These code clearly follow the java code conventions such as the the 
5.The shortage about this class is that he used so many repeat codes, most
of them can create a class and just use the class transfer parameter.   

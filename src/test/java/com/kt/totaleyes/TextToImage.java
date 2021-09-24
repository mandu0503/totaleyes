package com.kt.totaleyes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class TextToImage {

	public static class Item {
        private boolean error;
        private boolean displayLine;
        private String  row;
        
        public Item(boolean error, boolean displayLine, String row) {
            this.error = error;
            this.displayLine = displayLine;
            this.row = row;
        }

        public Boolean getError() {
            return this.error;
        }
        public String getRow() {
            return this.row;
        }
        public void setError(boolean error) {
            this.error = error;
        }
        public void setRow(String row) {
            this.row = row;
        }

    }
	
    public void run() throws IOException {
        int leftMargin = 16;
        int startline = 99;
        int fontSize = 16;
        String fontFamily = "바탕";
        int errorline = 2; // 에러 위치
                
        String text = 
        "clients.inMemory()\n" +
            ".withClient(\"myclientwith\")\n" +
            ".authorizedGrantTypes(\"client_credentials\", \"password\", \"refresh_token\", \"authorization_code\").authorities(\"ROLE_AICENTRO_CLIENT\").resourceIds(\"myresource\")" +
            ".scopes(\"read\", \"write\", \"read_only\", \"read_user\")\n" +
            "\n" +
            ".and()\n" +
            ".withClient(\"myclientwithout\")\n" +
            ".authorizedGrantTypes(\"client_credentials\", \"password\", \"refresh_token\", \"authorization_code\")\n" +
            ".authorities(\"ROLE_AICENTRO_CLIENT\")\n" +
            ".resourceIds(\"myresource\")\n" +
            ".scopes(UUID.randomUUID().toString());";
        
        String[] temps = text.split("\n");
        

        List<Item> letters = new ArrayList<Item>();

        int i=0;
        for(String str: temps) {
            int size = 60; // 한 라인에 표시될 사이즈
            boolean error = false;
            if (i == errorline) {
                error = true;
            }

            if (str.length() > size ) {
                int length = str.length();
                int position = str.length();
                int j=0;    
                while(position > 0) {
                    int start = j * size;
                    int end = (j+1) * size;
                    if (end > length) {
                        end = length;
                    }
                    String substr = str.substring(start, end);
                    position = position - size;
                    letters.add(new Item(error, j==0 ? true : false,  substr));
                    j++;
                }
            } else {
                letters.add(new Item(error, true, str));
            }
            i++;
        }

        // init
        int width = getMaxLengthWidthText(letters) * (fontSize/2) + 80;
        int height = (getMaxLengthHeightText(letters) + 3) * fontSize;
        
        System.out.println("width:" + width + ", height:" + height);
        Font font = new Font(fontFamily, Font.PLAIN, fontSize);
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2d = bufferedImage.createGraphics();

        // draw - canvas
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,  RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        graphics2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING,  RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        graphics2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        graphics2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        graphics2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2d.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        graphics2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        graphics2d.setColor(Color.YELLOW);

        graphics2d.fillRect(0, 0, width, height);

        // draw * text
        graphics2d.setFont(font);
       
        int verticalPosition = 0;
        int lineCount = 0;
        for (Item item: letters) {
            int verticalStart = (verticalPosition+2) * fontSize;
            String line = "";
            if (item.displayLine) {
                line = String.format("%5d", startline + lineCount);
                lineCount++;
            } else {
                line = "     ";
            }

            System.out.println(item.row);
            if (item.error) {
                graphics2d.setColor(Color.RED);
            } else {
                graphics2d.setColor(Color.BLACK);
            }
            graphics2d.drawString(line + "   " + item.row, leftMargin, verticalStart);
            verticalPosition++;
        }

        ImageIO.write(bufferedImage, "png", new File("C:/Temp/sample-newline.png"));
    }

    public int getMaxLengthWidthText(String[] source) {
        int maxSize = 0;

        for (String str : source) {
            int size = 0;
            for (int i = 0; i < str.length(); i++) {
                if (Character.getType(str.charAt(i)) == Character.OTHER_LETTER) {
                    size = size + 2;
                } else {
                    size = size + 1;
                }

            }
            if (maxSize < size)
                maxSize = size;
        }
        System.out.println(maxSize);
        return maxSize;
    }

    public int getMaxLengthWidthText(List<Item> source) {
        int maxSize = 0;
        for (Item item : source) {
            int size = 0;
            for (int i = 0; i < item.row.length(); i++) {
                if (Character.getType(item.row.charAt(i)) == Character.OTHER_LETTER) {
                    size = size + 2;
                } else {
                    size = size + 1;
                }

            }
            if (maxSize < size)
                maxSize = size;

        }
        return maxSize;
    }

    public int getMaxLengthHeightText(String[] source) {
        return source.length;
    }

    public int getMaxLengthHeightText(List<Item> source) {
        return source.size();
    }

   
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		TextToImage toImage = new TextToImage();
        toImage.run();
	}

}

public static void main(String[] args) {
   FileClient fileClient = new FileClient();
   String downloadedFile = FileClient.download("localhost", 8080, "example.txt");

   FileServer fileServer = new FileServer();
   try {
      fileServer.start(8080);
   } catch (IOException e) {
      e.printStackTrace();
   }

   String data = CloudDataReader.readDataFrom(downloadedFile);
   System.out.println(data);
}
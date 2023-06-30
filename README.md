

# PDF Splitter

PDF Splitter is a web application that allows users to split PDF files into individual pages. It provides a user-friendly interface for uploading PDF files and selecting the pages to split.

## Features

- Upload PDF files: Users can upload PDF files using the provided form.
- Split PDF files: Users can select the pages they want to split from the uploaded PDF file.
- Download split pages: Once the PDF is split, users can download the individual pages as separate PDF files.

## Technologies Used

- Backend: Java with Spring Boot
- Frontend: React.js
- Database: MySQL (or any other supported database)
- Libraries/Frameworks: Spring MVC, Thymeleaf, Axios, Bootstrap

## Prerequisites

Before running the application, ensure that you have the following installed:

- Java Development Kit (JDK)
- Node.js and npm (Node Package Manager)
- MySQL (or any other database of your choice)

## Getting Started

1. Clone the repository:

```
git clone https://github.com/your-username/pdf-splitter.git
```

2. Backend Setup:
   - Import the backend project in your preferred IDE.
   - Configure the database connection in `src/main/resources/application.properties`.
   - Run the Spring Boot application.

3. Frontend Setup:
   - Navigate to the `frontend` directory.
   - Install the dependencies using the following command:

   ```
   npm install
   ```

   - Start the React development server:

   ```
   npm start
   ```

4. Access the application:
   - Open your web browser and go to `http://localhost:3000`.
   - You should see the PDF Splitter application up and running.

## Folder Structure

```
pdf-splitter/
├─ backend/             # Backend Java project
│   ├─ src/             # Source files
│   ├─ pom.xml          # Maven dependencies and build configuration
│   └─ ...
├─ frontend/            # Frontend React project
│   ├─ public/          # Public assets
│   ├─ src/             # Source files
│   ├─ package.json     # npm dependencies and build configuration
│   └─ ...
└─ README.md            # Project README file
```

## Contributing

If you'd like to contribute to this project, you can follow these steps:

1. Fork the repository on GitHub.
2. Create a new branch with a descriptive name for your feature or bug fix.
3. Make the necessary changes and commit them.
4. Push your changes to your forked repository.
5. Submit a pull request detailing your changes and their purpose.



## Acknowledgments
- [Spring Boot](https://spring.io/projects/spring-boot) for the backend framework.
- [React](https://reactjs.org) for the frontend library.
- [Axios](https://axios-http.com) for handling HTTP requests.
- [Bootstrap](https://getbootstrap.com) for the frontend styling.

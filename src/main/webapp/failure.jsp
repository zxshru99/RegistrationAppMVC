<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Failed</title>
    <style>
        :root {
            --bg-color: #ecf0f1;
            --card-bg: #ffffff;
            --text-color: #333333;
            --error-color: #e74c3c;
            --error-hover: #c0392b;
        }

        * { box-sizing: border-box; margin: 0; padding: 0; }

        body {
            font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
            background-color: var(--bg-color);
            color: var(--text-color);
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            padding: 20px;
        }

        .status-container {
            background-color: var(--card-bg);
            width: 100%;
            max-width: 400px;
            padding: 40px 35px;
            border-radius: 6px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.05), 0 2px 10px rgba(0,0,0,0.08);
            text-align: center;
            border-top: 5px solid var(--error-color);
        }

        .status-icon {
            font-size: 48px;
            color: var(--error-color);
            margin-bottom: 15px;
            font-weight: bold;
        }

        .status-container h2 {
            margin-bottom: 15px;
            font-weight: 500;
            color: #2c3e50;
            font-size: 24px;
        }

        .status-message {
            font-size: 15px;
            color: #7f8c8d;
            margin-bottom: 30px;
            line-height: 1.5;
        }

        .action-btn {
            display: inline-block;
            width: 100%;
            padding: 14px;
            background-color: var(--error-color);
            color: #ffffff;
            text-decoration: none;
            border-radius: 4px;
            font-size: 16px;
            font-weight: bold;
            transition: background-color 0.2s ease;
        }

        .action-btn:hover { background-color: var(--error-hover); }

        @media (max-width: 480px) {
            .status-container { padding: 30px 20px; }
        }
    </style>
</head>
<body>

    <main class="status-container">
        <div class="status-icon">✕</div>
        <h2>Something Went Wrong</h2>
        <% String name=(String)session.getAttribute("name"); %>
        
        
        <!-- Displays dynamic error message if provided by the backend -->
        <p class="status-message">
         <h2>Hey<%=name%> </h2>
        
            ${not empty message ? message : 'We could not process your registration at this time. Please check your details and try again.'}
        </p>

        <!-- Use javascript:history.back() to preserve form data if they click Try Again -->
        <a href="javascript:history.back()" class="action-btn">Go Back and Try Again</a>
    </main>

</body>
</html>
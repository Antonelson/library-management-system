async function loginUser() {
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    const user = { email, password };

    try {
        const response = await fetch("http://localhost:8080/auth/login", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(user)
        });
        
        if (!response.ok) {
            const msg = await response.text();
            alert("Login failed: " + msg);
            return;
        }

        // Get token from backend
        const data = await response.json();
        const token = data.token; 
        // Save JWT in localStorage
        localStorage.setItem("jwt", token);

        window.location.href = "../Operation/main.html";

    } catch (error) {
        alert("Server error: " + error);
    }
}

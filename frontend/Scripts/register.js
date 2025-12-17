async function registerUser() {
  const email = document.getElementById("email").value;
  const password = document.getElementById("password").value;
  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!emailRegex.test(email)) {
    alert("Please enter a valid email address");
    return;
  }
  console.log(password,length);
  if (password.length <= 4) {
    alert("Enter Password more than 4 letter");
    return;
  }
  const user = {
    email: email,
    password: password,
  };

  try {
    const response = await fetch("http://localhost:8080/auth/register", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(user),
    });

    if (!response.ok) {
      const msg = await response.text();
      alert("Registration failed: " + msg);
      return;
    }

    alert("Registration successful! Please login.");
    window.location.href = "login.html";
  } catch (error) {
    alert("Server error: " + error);
  }
}

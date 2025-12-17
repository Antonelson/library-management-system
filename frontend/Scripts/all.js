const URL = "http://localhost:8080";

//DElETE
async function deletefun() {
  const id = document.getElementById("id").value;
  const token = localStorage.getItem("jwt");

  try {
    const response = await fetch(`${URL}/library/api/delete?id=${id}`, {
      method: "DELETE",
      headers: { Authorization: `Bearer ${token}` },
    });
    const msg = await response.text();
    if (!response.ok) {
      alert( "ENTER VALID BOOK NO");
      return;
    }
    alert("DELETED SUCESSFULLY");
  } catch (e) {
    alert("EXCEPTION:" + e);
  }
}
async function postfun() {
  const bookNo = document.getElementById("bookNo").value;
  const bookName = document.getElementById("bookName").value;
  const author = document.getElementById("author").value;
  const shelfId = document.getElementById("shelfId").value;

  const token = localStorage.getItem("jwt");

  const resbody = {
    bookNo: bookNo,
    bookName: bookName,
    author: author,
    shelfId: shelfId,
  };
  try {
    const res = await fetch(`${URL}/library/api/create`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`,
      },
      body: JSON.stringify(resbody),
    });
    const msg = await res.text();
    if (!res.ok) {
      alert("ERROR" + msg);
    }
    alert("ENTERED SUCESSFULLY");
    window.location.href="../Operation/main.html"
  } catch (e) {
    alert(e);
  }
  
}

async function putfun() {
  const resbody = {
    bookNo: document.getElementById("bookNo").value,
    bookName: document.getElementById("bookName").value,
    author: document.getElementById("author").value,
    shelfId: document.getElementById("shelfId").value,
  };

  const token = localStorage.getItem("jwt");
  try {
    const response = await fetch(`${URL}/library/api/update`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`,
      },
      body: JSON.stringify(resbody),
    });
    const msg = await response.text();
    if (!response.ok) {
      alert("ERROR" + msg);
    }
    alert("UPDATED SUCESSFULLY");
    window.location.href="../Operation/main.html"
  } catch (e) {
    alert("EXCEPTION:" + e);
  }


}

async function getfun() {
  const token = localStorage.getItem("jwt");

  const response = await fetch(`${URL}/library/api/get`, {
    method: "GET",
    headers: {
      Accept: "application/json",
      Authorization: `Bearer ${token}`,
    },
  });

  const data = await response.json();

  const box = document.getElementById("libraryList");

  box.innerHTML = "";

  data.forEach((b) => {
    box.innerHTML += `
      <div class="divu">
        <strong>Book No:</strong> ${b.bookNo}<br>
        <strong>Name:</strong> ${b.bookName}<br>
        <strong>Author:</strong> ${b.author}<br>
        <strong>Shelf:</strong> ${b.shelfId}
      </div>
      <hr>
    `;
  });
}
async function getfunone() {
  const token = localStorage.getItem("jwt");
  const id = localStorage.getItem("id");
  // localStorage.removeItem("id");

  try {
    const response = await fetch(`${URL}/library/api/get/${id}`, {
      method: "GET",
      headers: {
        Accept: "application/json",
        Authorization: `Bearer ${token}`,
      },
    });
    if (response.status === 404) {
      const msg = await response.text();
      alert("Backend says: " + msg);
      window.location.href = "../Operation/getdetails.html";
      return;
    }

    if (!response.ok) {
      alert("Something went wrong. Status: " + res.status);
      return;
    }
    const data = await response.json();

    const box = document.getElementById("library");
    box.innerHTML = `<h2>Detail</h2>
    <div class="divu">
        <strong>Book No:</strong> ${data.bookNo}<br>
        <strong>Name:</strong> ${data.bookName}<br>
        <strong>Author:</strong> ${data.author}<br>
        <strong>Shelf:</strong> ${data.shelfId}
      </div>`;
  } catch (e) {
    console.log(e);
  }
}

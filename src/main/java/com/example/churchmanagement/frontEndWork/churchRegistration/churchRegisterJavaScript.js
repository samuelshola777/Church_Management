// Function to handle form submission
function handleSubmit(event) {
    event.preventDefault(); // Prevent form from submitting

    // Get form inputs
    var nameInput = document.getElementById("name");
    var emailInput = document.getElementById("email");
    var messageInput = document.getElementById("message");

    // Perform form validation
    if (!nameInput.value || !emailInput.value || !messageInput.value) {
        alert("Please fill in all fields");
        return;
    }

    // Send form data to server (You can customize this part based on your backend implementation)
    var formData = {
        name: nameInput.value,
        email: emailInput.value,
        message: messageInput.value
    };

    // Perform an AJAX request to submit the form data
    // Example using the Fetch API
    fetch("/submit-form", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(formData)
    })
        .then(function(response) {
            if (response.ok) {
                alert("Form submitted successfully!");
                // Reset form inputs
                nameInput.value = "";
                emailInput.value = "";
                messageInput.value = "";
            } else {
                alert("Form submission failed. Please try again.");
            }
        })
        .catch(function(error) {
            console.error("Error submitting form:", error);
            alert("An error occurred. Please try again later.");
        });
}

// Attach form submit event listener
var form = document.getElementById("contact-form");
form.addEventListener("submit", handleSubmit);

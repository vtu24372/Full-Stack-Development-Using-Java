// ============================================
// JOB PORTAL MANAGEMENT SYSTEM
// Main JavaScript File
// ============================================

// Wait for DOM to load
document.addEventListener('DOMContentLoaded', function() {
    console.log('Job Portal System Loaded');
    
    // Initialize all components
    initializeSidebar();
    initializeNotifications();
    initializeFormValidation();
    initializeSearchFilters();
    initializeCharts();
});

// ============================================
// SIDEBAR TOGGLE FOR MOBILE
// ============================================
function initializeSidebar() {
    const sidebar = document.querySelector('.sidebar');
    const menuToggle = document.querySelector('.menu-toggle');
    
    if (menuToggle) {
        menuToggle.addEventListener('click', function() {
            sidebar.classList.toggle('open');
        });
    }
}

// ============================================
// NOTIFICATION SYSTEM
// ============================================
function initializeNotifications() {
    // Auto-hide alerts after 5 seconds
    const alerts = document.querySelectorAll('.alert');
    alerts.forEach(alert => {
        setTimeout(() => {
            alert.style.opacity = '0';
            setTimeout(() => {
                alert.remove();
            }, 500);
        }, 5000);
    });
}

function showNotification(message, type) {
    const notification = document.createElement('div');
    notification.className = `alert alert-${type}`;
    notification.innerHTML = `
        <i class="fas ${type === 'success' ? 'fa-check-circle' : 'fa-exclamation-circle'}"></i>
        <span>${message}</span>
    `;
    
    const container = document.querySelector('.main-content') || document.querySelector('.auth-container');
    if (container) {
        container.insertBefore(notification, container.firstChild);
        
        setTimeout(() => {
            notification.style.opacity = '0';
            setTimeout(() => {
                notification.remove();
            }, 500);
        }, 5000);
    }
}

// ============================================
// FORM VALIDATION
// ============================================
function initializeFormValidation() {
    // Job posting form validation
    const jobForm = document.querySelector('.job-form');
    if (jobForm) {
        jobForm.addEventListener('submit', function(e) {
            const title = document.querySelector('input[name="title"]');
            const description = document.querySelector('textarea[name="description"]');
            const location = document.querySelector('input[name="location"]');
            const salary = document.querySelector('input[name="salary"]');
            
            if (title && !title.value.trim()) {
                e.preventDefault();
                showNotification('Please enter job title', 'error');
                title.focus();
                return false;
            }
            
            if (description && !description.value.trim()) {
                e.preventDefault();
                showNotification('Please enter job description', 'error');
                description.focus();
                return false;
            }
            
            if (location && !location.value.trim()) {
                e.preventDefault();
                showNotification('Please enter job location', 'error');
                location.focus();
                return false;
            }
            
            if (salary && !salary.value.trim()) {
                e.preventDefault();
                showNotification('Please enter salary range', 'error');
                salary.focus();
                return false;
            }
            
            showNotification('Job posted successfully!', 'success');
            return true;
        });
    }
    
    // Profile form validation
    const profileForm = document.querySelector('.profile-form');
    if (profileForm) {
        profileForm.addEventListener('submit', function(e) {
            const name = document.querySelector('input[name="name"]');
            const skills = document.querySelector('input[name="skills"]');
            
            if (name && !name.value.trim()) {
                e.preventDefault();
                showNotification('Please enter your name', 'error');
                name.focus();
                return false;
            }
            
            if (skills && !skills.value.trim()) {
                e.preventDefault();
                showNotification('Please enter your skills', 'error');
                skills.focus();
                return false;
            }
            
            showNotification('Profile updated successfully!', 'success');
            return true;
        });
    }
}

// ============================================
// SEARCH & FILTER FUNCTIONS
// ============================================
function initializeSearchFilters() {
    // Real-time search for jobs
    const searchInput = document.getElementById('searchInput');
    if (searchInput) {
        searchInput.addEventListener('keyup', function() {
            filterJobsTable();
        });
    }
}

function filterJobsTable() {
    const searchTerm = document.getElementById('searchInput')?.value.toLowerCase() || '';
    const rows = document.querySelectorAll('#jobsTableBody tr, .job-card, .applicant-card');
    
    rows.forEach(row => {
        const text = row.textContent.toLowerCase();
        if (text.includes(searchTerm)) {
            row.style.display = '';
        } else {
            row.style.display = 'none';
        }
    });
}

function filterByCategory(category) {
    const rows = document.querySelectorAll('#jobsTableBody tr');
    rows.forEach(row => {
        const categoryCell = row.querySelector('.category');
        if (category === 'all' || (categoryCell && categoryCell.textContent === category)) {
            row.style.display = '';
        } else {
            row.style.display = 'none';
        }
    });
}

function filterByStatus(status) {
    const cards = document.querySelectorAll('.application-card, .job-card');
    cards.forEach(card => {
        if (status === 'all' || card.dataset.status === status) {
            card.style.display = '';
        } else {
            card.style.display = 'none';
        }
    });
}

// ============================================
// APPLICATION FUNCTIONS
// ============================================
function applyForJob(jobId) {
    // Check if user is logged in
    const isLoggedIn = document.querySelector('.nav-user') !== null;
    
    if (!isLoggedIn) {
        showNotification('Please login to apply for jobs', 'error');
        setTimeout(() => {
            window.location.href = '/auth/login';
        }, 2000);
        return;
    }
    
    // Check if resume is uploaded
    const hasResume = document.querySelector('.current-resume') !== null;
    
    if (!hasResume) {
        showNotification('Please upload your resume in profile first', 'error');
        setTimeout(() => {
            window.location.href = '/jobseeker/profile';
        }, 2000);
        return;
    }
    
    // Submit application
    showNotification('Application submitted successfully!', 'success');
    
    // Simulate API call
    setTimeout(() => {
        window.location.href = '/jobseeker/applications';
    }, 1500);
}

function withdrawApplication(applicationId) {
    if (confirm('Are you sure you want to withdraw this application?')) {
        showNotification('Application withdrawn successfully', 'success');
        // Remove the application card from UI
        const card = document.querySelector(`.application-card[data-id="${applicationId}"]`);
        if (card) {
            card.remove();
        }
    }
}

// ============================================
// EMPLOYER FUNCTIONS
// ============================================
function updateStatus(button, newStatus, applicationId) {
    const card = button.closest('.applicant-card');
    const statusSpan = card.querySelector('.status-badge');
    
    card.dataset.status = newStatus;
    
    if (newStatus === 'SHORTLISTED') {
        statusSpan.className = 'status-badge shortlisted';
        statusSpan.innerHTML = 'Shortlisted <i class="fas fa-check"></i>';
        showNotification('Candidate shortlisted successfully!', 'success');
    } else if (newStatus === 'REJECTED') {
        statusSpan.className = 'status-badge rejected';
        statusSpan.innerHTML = 'Rejected <i class="fas fa-times"></i>';
        showNotification('Candidate rejected', 'info');
    }
    
    // Disable buttons after action
    const buttons = card.querySelectorAll('button');
    buttons.forEach(btn => {
        btn.disabled = true;
        btn.style.opacity = '0.5';
    });
}

function viewResume(resumePath) {
    if (resumePath) {
        window.open(resumePath, '_blank');
    } else {
        showNotification('Resume not available', 'error');
    }
}

function deleteJob(jobId) {
    if (confirm('Are you sure you want to delete this job posting?')) {
        showNotification('Job deleted successfully', 'success');
        // Remove job card from UI
        const card = document.querySelector(`.job-card[data-id="${jobId}"]`);
        if (card) {
            card.remove();
        }
    }
}

// ============================================
// ADMIN FUNCTIONS
// ============================================
function toggleUserStatus(userId, currentStatus) {
    const action = currentStatus === 'active' ? 'suspend' : 'activate';
    if (confirm(`Are you sure you want to ${action} this user?`)) {
        showNotification(`User ${action}d successfully`, 'success');
        // Update UI
        const row = document.querySelector(`tr[data-id="${userId}"]`);
        if (row) {
            const statusSpan = row.querySelector('.status-active, .status-inactive');
            if (currentStatus === 'active') {
                statusSpan.className = 'status-inactive';
                statusSpan.textContent = 'Inactive';
            } else {
                statusSpan.className = 'status-active';
                statusSpan.textContent = 'Active';
            }
        }
    }
}

function deleteUser(userId) {
    if (confirm('Are you sure you want to permanently delete this user?')) {
        showNotification('User deleted successfully', 'success');
        const row = document.querySelector(`tr[data-id="${userId}"]`);
        if (row) {
            row.remove();
        }
    }
}

// ============================================
// EXPORT FUNCTIONS
// ============================================
function exportReport(type) {
    showNotification(`Exporting ${type} report...`, 'success');
    
    // Simulate export
    setTimeout(() => {
        showNotification(`${type} report exported successfully!`, 'success');
    }, 2000);
}

function exportAnalytics() {
    exportReport('Analytics');
}

// ============================================
// CHART INITIALIZATION (if Chart.js is loaded)
// ============================================
function initializeCharts() {
    // Check if Chart is available
    if (typeof Chart === 'undefined') return;
    
    // User Growth Chart
    const userChartCanvas = document.getElementById('userChart');
    if (userChartCanvas) {
        new Chart(userChartCanvas, {
            type: 'line',
            data: {
                labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun'],
                datasets: [{
                    label: 'Users',
                    data: [65, 78, 92, 108, 135, 162],
                    borderColor: '#00D4FF',
                    backgroundColor: 'rgba(0, 212, 255, 0.1)',
                    tension: 0.4,
                    fill: true
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: true,
                plugins: {
                    legend: {
                        labels: { color: '#fff' }
                    }
                },
                scales: {
                    y: {
                        ticks: { color: '#fff' },
                        grid: { color: 'rgba(255, 255, 255, 0.1)' }
                    },
                    x: {
                        ticks: { color: '#fff' },
                        grid: { color: 'rgba(255, 255, 255, 0.1)' }
                    }
                }
            }
        });
    }
    
    // Job Distribution Chart
    const jobChartCanvas = document.getElementById('jobChart');
    if (jobChartCanvas) {
        new Chart(jobChartCanvas, {
            type: 'doughnut',
            data: {
                labels: ['IT', 'Marketing', 'Sales', 'Finance', 'HR'],
                datasets: [{
                    data: [45, 28, 32, 25, 18],
                    backgroundColor: ['#00D4FF', '#FF6B35', '#FFD700', '#FF8C00', '#0099cc'],
                    borderWidth: 0
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: true,
                plugins: {
                    legend: {
                        labels: { color: '#fff' }
                    }
                }
            }
        });
    }
}

// ============================================
// PASSWORD TOGGLE FUNCTION
// ============================================
function togglePassword(icon) {
    const input = icon.parentElement.querySelector('input');
    if (input.type === 'password') {
        input.type = 'text';
        icon.innerHTML = '<i class="fas fa-eye-slash"></i>';
    } else {
        input.type = 'password';
        icon.innerHTML = '<i class="fas fa-eye"></i>';
    }
}

// ============================================
// MARK NOTIFICATIONS AS READ
// ============================================
function markAllRead() {
    const unreadItems = document.querySelectorAll('.notification-item.unread');
    unreadItems.forEach(item => {
        item.classList.remove('unread');
    });
    showNotification('All notifications marked as read', 'success');
}

// ============================================
// CONTACT EMPLOYER FUNCTION
// ============================================
function contactEmployer(employerEmail) {
    if (employerEmail) {
        window.location.href = `mailto:${employerEmail}`;
    } else {
        showNotification('Email client opening...', 'info');
    }
}

// ============================================
// SCROLL TO TOP FUNCTION
// ============================================
function scrollToTop() {
    window.scrollTo({ top: 0, behavior: 'smooth' });
}

// Add scroll to top button
window.addEventListener('scroll', function() {
    const scrollBtn = document.getElementById('scrollTopBtn');
    if (window.scrollY > 300) {
        if (!scrollBtn) {
            const btn = document.createElement('button');
            btn.id = 'scrollTopBtn';
            btn.innerHTML = '<i class="fas fa-arrow-up"></i>';
            btn.style.cssText = `
                position: fixed;
                bottom: 30px;
                right: 30px;
                background: linear-gradient(135deg, #00D4FF, #FF6B35);
                color: white;
                border: none;
                width: 50px;
                height: 50px;
                border-radius: 50%;
                cursor: pointer;
                z-index: 1000;
                transition: all 0.3s ease;
            `;
            btn.onclick = scrollToTop;
            document.body.appendChild(btn);
        }
    } else if (scrollBtn) {
        scrollBtn.remove();
    }
});

// ============================================
// CONFIRM DELETE FUNCTION
// ============================================
function confirmDelete(itemName) {
    return confirm(`Are you sure you want to delete ${itemName}? This action cannot be undone.`);
}

// ============================================
// LOADING STATE FUNCTION
// ============================================
function showLoading(button) {
    const originalText = button.innerHTML;
    button.innerHTML = '<i class="fas fa-spinner fa-spin"></i> Loading...';
    button.disabled = true;
    
    return function() {
        button.innerHTML = originalText;
        button.disabled = false;
    };
}

// Export functions for global use
window.applyForJob = applyForJob;
window.withdrawApplication = withdrawApplication;
window.updateStatus = updateStatus;
window.viewResume = viewResume;
window.deleteJob = deleteJob;
window.toggleUserStatus = toggleUserStatus;
window.deleteUser = deleteUser;
window.exportReport = exportReport;
window.exportAnalytics = exportAnalytics;
window.togglePassword = togglePassword;
window.markAllRead = markAllRead;
window.contactEmployer = contactEmployer;
window.scrollToTop = scrollToTop;
window.confirmDelete = confirmDelete;
window.filterByCategory = filterByCategory;
window.filterByStatus = filterByStatus;
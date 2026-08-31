import { describe, it, expect } from 'vitest';
import { render, screen } from '@testing-library/react';
import React from 'react';
import { CustomerDashboardPage } from '../pages/dashboard/CustomerDashboardPage';

describe('Customer Dashboard Page', () => {
  it('renders dashboard metrics header', () => {
    render(<CustomerDashboardPage />);
    expect(screen.getByText('Financial Command Center')).toBeDefined();
  });
});
